package com.training.ged.shared;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SharedConfiguration {

    @Bean
    Referential referential(){
        return new Referential();
    }

}
