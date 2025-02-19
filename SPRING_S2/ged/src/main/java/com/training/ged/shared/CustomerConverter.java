package com.training.ged.shared;


import com.training.ged.domain.model.Customer;
import com.training.ged.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CustomerConverter implements Converter<String, Customer> {

    private final CustomerService customerService;

    @Override
    public Customer convert(String customerId) {
        List<Customer> customerList = customerService.findCustomers();
        var optional = customerList
                .stream().filter( i -> i.getId().equals(UUID.fromString(customerId)))
                .findFirst();
        return optional
                .orElseThrow(() -> new IllegalArgumentException("Customer with ID '" + customerId + "' not found!"));
    }
}