package com.training.ged.domain.service;

import com.training.ged.domain.model.Customer;
import com.training.ged.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Optional<Customer> findCustomer(UUID id) {
        return customerRepository
                .findById(id)
                .map(x-> Customer.builder()
                        .id(x.getId())
                        .firstName(x.getFirstName())
                        .lastName(x.getLastName())
                        .build());
    }

    public List<Customer> findCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(x-> Customer.builder()
                        .id(x.getId())
                        .firstName(x.getFirstName())
                        .lastName(x.getLastName())
                        .build())
                .toList();
    }
}
