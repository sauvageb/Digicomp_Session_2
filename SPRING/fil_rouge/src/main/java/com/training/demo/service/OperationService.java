package com.training.demo.service;

import com.training.demo.repository.entity.OperationEntity;
import com.training.demo.model.Operation;
import com.training.demo.model.OperationDirection;
import com.training.demo.repository.OperationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OperationService {

    private OperationRepository operationRepository;

    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public List<Operation> getOperations() {
        List<OperationEntity> entities = operationRepository.findAll();

        // Entity vers Operation
        return entities
                .stream()
                .map(OperationEntity::toOperation)
                .toList();
    }


    public Optional<Operation> getOperationById(UUID id) {
        Optional<OperationEntity> entityOpt = operationRepository.findById(id);
        return entityOpt.map(OperationEntity::toOperation);
    }

    public void createOperation(double amount, OperationDirection direction) {

        OperationEntity newEntity = new OperationEntity(
                UUID.randomUUID(),
                LocalDateTime.now(),
                amount,
                direction);

        operationRepository.save(newEntity);
    }

    public boolean delete(UUID id) {
        Optional<OperationEntity> optionalOperation = operationRepository.findById(id);
        if (optionalOperation.isPresent()) {
            operationRepository.delete(optionalOperation.get());
            return true;
        }
        return false;
    }

    public void deleteAll() {
        operationRepository.deleteAll();
    }

    public List<Operation> searchOperations(String searchId) {
        List<OperationEntity> entities = operationRepository.searchByIdLike(searchId);

        // Entity vers Operation
        return entities
                .stream()
                .map(OperationEntity::toOperation)
                .toList();
    }

    public boolean updateOperation(UUID id, double amount, OperationDirection direction) {
        return operationRepository.findById(id)
                .map(oldEntity -> {
                    oldEntity.setAmount(amount);
                    oldEntity.setDirection(direction);
                    return operationRepository.save(oldEntity);
                }).isPresent();
    }
}
