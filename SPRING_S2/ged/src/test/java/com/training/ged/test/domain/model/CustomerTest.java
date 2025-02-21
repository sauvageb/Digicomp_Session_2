package com.training.ged.test.domain.model;


import com.training.ged.domain.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class CustomerTest {

    @Test
    public void customerBuilder(){
        // Given
        UUID id = UUID.randomUUID();
        String firstName = "Boris";
        String lastName = "SAUVAGE";

        // When
        var result = Customer.builder()
                .id(id)
                .lastName(lastName)
                .firstName(firstName)
                .build();

        // Then
        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.getId(), "UUID are differents");
        Assertions.assertEquals(firstName, result.getFirstName());
        Assertions.assertEquals(lastName, result.getLastName());
    }


}