package com.training.ged.shared;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAsync
public class RestTemplateAsync {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplateBuilder()
                .build();
    }
}