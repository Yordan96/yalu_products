package com.example.auditservice.repository;

import com.example.auditservice.entity.AuditLog;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AuditLogRepository extends ReactiveMongoRepository<AuditLog, String>{
}
