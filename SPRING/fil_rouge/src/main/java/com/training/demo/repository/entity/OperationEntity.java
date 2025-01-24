package com.training.demo.repository.entity;

import com.training.demo.model.Operation;
import com.training.demo.model.OperationDirection;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_operations")
public class OperationEntity {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
    private LocalDateTime createdAt;
    private double amount;

    @Column(name = "direction")
    @Enumerated(EnumType.STRING)
    private OperationDirection direction;

    public OperationEntity() {
    }

    public OperationEntity(UUID id, LocalDateTime createdAt, double amount, OperationDirection direction) {
        this.id = id;
        this.createdAt = createdAt;
        this.amount = amount;
        this.direction = direction;
    }

    public Operation toOperation() {
        return new Operation(
                this.getId(),
                this.getCreatedAt(),
                this.getAmount(),
                this.getDirection());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OperationDirection getDirection() {
        return direction;
    }

    public void setDirection(OperationDirection direction) {
        this.direction = direction;
    }
}


