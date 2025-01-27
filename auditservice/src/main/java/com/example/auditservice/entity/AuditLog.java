package com.example.auditservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "audit_logs")
@Data
public class AuditLog {
    @Id
    private String id;
    private String event;
    private String timestamp;
}
