package com.rdm.rdm.entity;

import Animals.AbstractAnimal;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Animal")
public class AnimalDb{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "AnimalTypeId")
    private String animalTypeId;

    @Column(name = "Breed")
    private String breed; // порода

    @Column(name = "Name")
    private String name; // имя

    @Column(name = "Cost")
    private Double cost; // цена в магазине

    @Column(name = "Character")
    private String character; // характер


}
