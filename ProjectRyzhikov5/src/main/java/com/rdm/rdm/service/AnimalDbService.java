package com.rdm.rdm.service;

import com.rdm.rdm.entity.AnimalDb;
import com.rdm.rdm.repo.AnimalDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Component
public class AnimalDbService {

    @Autowired
    private AnimalDbRepository animalDbRepository;

    /*List<AnimalDb> getAnimalsByName{

    }*/

    /*List<AnimalDb> getAllAnimals{
        return animalDbRepository.findAll();
    }*/

    public List<AnimalDb> findByCharacter(String character){
        return animalDbRepository.findByCharacter(character);
    }

    /*void deleteAnimal{

    }*/

    void addAnimal (AnimalDb animalDb){
        animalDbRepository.save(animalDb);
    }
}
