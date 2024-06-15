package com.rdm.rdm.config;

import Interfaces.CreateAnimalService;
import com.rdm.rdm.implementations.CreateAnimalServiceImpl;
import org.springframework.context.annotation.*;

//@Configuration
public class BeanConfiguration {

    @Bean
    @Scope("prototype")
    public CreateAnimalService createAnimalService() {
        return new CreateAnimalServiceImpl();
    }

    @Bean
    @Scope("prototype")
    @Profile("test")
    public CreateAnimalService createAnimalServiceTest() {
        return new CreateAnimalServiceImpl();
    }
}
