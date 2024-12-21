package org.example.Classes;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "specialist")
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FIO")
    private String fio;

    @Column(name = "job")
    private String job;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "specialist", cascade = CascadeType.ALL)
    private Set<Pet> pets = new HashSet<>();

    public Specialist() {}

    public Specialist(String fio, String job) {
        this.fio = fio;
        this.job = job;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPet(Pet pet) {
        pet.setSpecialist(this);
        pets.add(pet);
    }

    public int getId() {
        return id;
    }

    public void removePet(Pet pet) {
        pet.removeSpecialist();
        pets.remove(pet);
    }

    public void clearPets() {
        pets.clear();
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", fio=" + fio +
                ", job=" + job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialist that = (Specialist) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }
}
