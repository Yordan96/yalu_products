package com.example.auditservice.service;

import com.example.auditservice.entity.AuditLog;
import com.example.auditservice.repository.AuditLogRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuditService {
    private final AuditLogRepository repository;

    public AuditService(AuditLogRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "product-events", groupId = "audit-service")
    public void consumeProductEvent(String event) {
        AuditLog log = new AuditLog();
        log.setEvent(event);
        log.setTimestamp(String.valueOf(System.currentTimeMillis()));
        repository.save(log).subscribe();
    }
}
