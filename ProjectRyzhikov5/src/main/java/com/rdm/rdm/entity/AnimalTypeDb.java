package com.rdm.rdm.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "animaltype")
public class AnimalTypeDb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "animaltype")
    private String animalType;

    public AnimalTypeDb(Long id, String animalType) {
        this.id = id;
        this.animalType = animalType;
    }
}
