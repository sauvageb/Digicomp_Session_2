package com.training.demo.controller.api;

import ch.qos.logback.core.util.StringUtil;
import com.training.demo.dto.CreateOperation;
import com.training.demo.model.Operation;
import com.training.demo.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/operations")
public class OperationRestController {

    @Autowired
    private OperationService operationService;

    @GetMapping
    public ResponseEntity<List<Operation>> fetchAll(@RequestParam(value = "searchId", required = false) String searchId) {
        List<Operation> operations;
        if (StringUtil.isNullOrEmpty(searchId)) {
            operations = operationService.searchOperations(searchId);
        } else {
            operations = operationService.getOperations();
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(operations);
    }

    @GetMapping("{idParam}")
    public ResponseEntity<Operation> fetchById(@PathVariable("idParam") UUID id) {
        Operation operation = operationService
                .getOperationById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return ResponseEntity.status(HttpStatus.OK).body(operation);
    }


    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateOperation operation) {
        operationService.createOperation(operation.getAmount(), operation.getDirection());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        if (operationService.delete(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable("id") UUID id, @RequestBody Operation operationDto) {
        boolean updated = operationService.updateOperation(id, operationDto.amount(), operationDto.direction());
        if (updated) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
