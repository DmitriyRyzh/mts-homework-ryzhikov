package com.rdm.rdm.config;

import Interfaces.AnimalsRepository;
import Interfaces.CreateAnimalService;
import com.rdm.rdm.implementations.AnimalsRepositoryImpl;
import com.rdm.rdm.implementations.CreateAnimalServiceImpl;
import com.rdm.rdm.repo.AnimalDbRepository;
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

    @Bean
    @Scope("prototype")
    public AnimalsRepository animalsRepository() {
        return new AnimalsRepositoryImpl();
    }
}
