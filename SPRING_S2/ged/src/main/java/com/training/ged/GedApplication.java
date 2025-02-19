package com.training.ged;

import com.training.ged.repository.entity.CustomerEntity;
import com.training.ged.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class GedApplication implements CommandLineRunner {

	private final CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(GedApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		var c1 = CustomerEntity.builder()
				.id(UUID.randomUUID())
				.firstName("Boris")
				.lastName("Sauvage")
				.build();
		var c2 = CustomerEntity.builder()
				.id(UUID.randomUUID())
				.firstName("Suna")
				.lastName("D")
				.build();
		customerRepository.saveAll(List.of(c1, c2));
	}
}
