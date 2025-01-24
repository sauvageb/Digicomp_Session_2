package com.training.demo.csv;

import com.opencsv.bean.CsvBindByName;

public class OperationCSVRepresentation {
    @CsvBindByName(column = "IDENTIFIANT")
    private String id;

    @CsvBindByName(column = "DATE_CREATION")
    private String createdAt;

    @CsvBindByName(column = "MONTANT")
    private String amount;

    @CsvBindByName(column = "DIRECTION")
    private String direction;

    public OperationCSVRepresentation() {
    }

    public OperationCSVRepresentation(String id, String createdAt, String amount, String direction) {
        this.id = id;
        this.createdAt = createdAt;
        this.amount = amount;
        this.direction = direction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}