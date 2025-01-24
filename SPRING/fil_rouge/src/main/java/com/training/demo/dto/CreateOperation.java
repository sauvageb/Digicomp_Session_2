package com.training.demo.dto;

import com.training.demo.model.OperationDirection;

public class CreateOperation {

    private double amount;
    private OperationDirection direction;

    public CreateOperation() {
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

    @Override
    public String toString() {
        return "CreateOperation{" +
                "amount=" + amount +
                ", direction=" + direction +
                '}';
    }
}
