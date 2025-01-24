package com.training.demo.csv;

import com.training.demo.model.Operation;
import org.springframework.stereotype.Service;

@Service
public class OperationMapper implements CSVMapper<Operation, OperationCSVRepresentation> {

    @Override
    public Operation mapTo(OperationCSVRepresentation r) {
//       return new Operation(r.getId(), r.getCreatedAt(), r.getAmount(), r.getDirection());
        return null;
    }

    @Override
    public OperationCSVRepresentation unmapFrom(Operation operation) {
        return new OperationCSVRepresentation(
                operation.id().toString(),
                operation.createdAt().toString(),
                String.valueOf(operation.amount()),
                operation.direction().name());
    }
}