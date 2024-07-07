package com.rdm.rdm.service;

import com.rdm.rdm.entity.AnimalDb;
import com.rdm.rdm.repo.AnimalDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Component
public class AnimalDbService {

    @Autowired
    private AnimalDbRepository animalDbRepository;


    public List<AnimalDb> getAllAnimals(){
        return animalDbRepository.findAll();
    }

    public List<AnimalDb> getAnimalsByName(String name){
        return animalDbRepository.findByName(name);
    }

    /*public List<AnimalDb> getAnimalsById(Long id){
        return animalDbRepository.findById(id);
    }*/

    public AnimalDb addAnimal(AnimalDb animalDb) {
        return animalDbRepository.save(animalDb);
    }

    public Optional<AnimalDb> findById(Long id){
        return animalDbRepository.findById(id);
    }

    public void deleteById(Long id) {

        //animalDbRepository.deleteById(findById(id).orElseThrow(() -> new EmptyResultDataAccessException(
        //        String.format("No animal entity with id %s exists", id), 1)).getId());

        try{
            animalDbRepository.deleteById(id);
        } catch(Exception e){
            System.out.println(String.format("Ошибка при попытке удаления животного %s", id));
        }
    }

}
