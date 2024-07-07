package com.rdm.rdm.repo;

import com.rdm.rdm.entity.AnimalDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalDbRepository extends JpaRepository<AnimalDb, Long> {

    //List<AnimalDb> getAllAnimals();
    List<AnimalDb> findByName(String name);
    Optional<AnimalDb> findById(Long id);
}
