package com.rdm.rdm.entity;

import Animals.AbstractAnimal;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Animal")
public class AnimalDb{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "animaltypeid")
    @ManyToOne
    private AnimalTypeDb animalTypeDb;

    @Column(name = "breed")
    private String breed; // порода

    @Column(name = "name")
    private String name; // имя

    @Column(name = "cost")
    private Double cost; // цена в магазине

    @Column(name = "character")
    private String character; // характер

    @Column(name = "birthdate")
    private LocalDate birthDate;

    public AnimalDb(Long id, AnimalTypeDb animalTypeDb, String breed, String name,
                    Double cost, String character, LocalDate birthDate) {
        this.id = id;
        this.animalTypeDb = animalTypeDb;
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnimalTypeDb getAnimalTypeDb() {
        return animalTypeDb;
    }

    public void setAnimalTypeDb(AnimalTypeDb animalTypeDb) {
        this.animalTypeDb = animalTypeDb;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
