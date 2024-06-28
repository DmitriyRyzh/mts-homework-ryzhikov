package com.rdm.rdm.service;

import com.rdm.rdm.entity.AnimalTypeDb;
import com.rdm.rdm.repo.AnimalTypeDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Component
public class AnimalTypeDbService {

    @Autowired
    private AnimalTypeDbRepository animalTypeDbRepository;

    public List<AnimalTypeDb> findByAnimalType(String animalTypeDb){
        return animalTypeDbRepository.findByAnimalType(animalTypeDb);
    }
}
