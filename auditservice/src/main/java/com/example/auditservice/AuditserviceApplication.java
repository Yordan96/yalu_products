package com.example.auditservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class AuditserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditserviceApplication.class, args);
	}

}
