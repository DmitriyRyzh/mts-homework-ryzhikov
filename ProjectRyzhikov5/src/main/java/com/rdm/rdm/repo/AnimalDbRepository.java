package com.rdm.rdm.repo;

import com.rdm.rdm.entity.AnimalDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalDbRepository extends JpaRepository<AnimalDb, Long> {

    List<AnimalDb> findByCharacter(String character);
}
