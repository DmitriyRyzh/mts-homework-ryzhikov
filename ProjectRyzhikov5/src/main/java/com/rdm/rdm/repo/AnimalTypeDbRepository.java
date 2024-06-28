package com.rdm.rdm.repo;

import com.rdm.rdm.entity.AnimalDb;
import com.rdm.rdm.entity.AnimalTypeDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalTypeDbRepository  extends JpaRepository<AnimalTypeDb, Long> {
    List<AnimalTypeDb> findByAnimalType(String animalTypeDb);

}
