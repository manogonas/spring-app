package org.example.Classes;

import jakarta.persistence.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table (name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 2, max = 50,message="2-50 letters")
    @Column(name = "FIO")
    private String fio;
    @Size(min = 11, max = 11, message="11 letters")
    @Pattern(regexp = "^89\\d{9}", message = "should start with 89 and only contain numbers")
    @Column(name = "phone_number")
    private String number;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "pet_owner", joinColumns = @JoinColumn(name = "owner"),
        inverseJoinColumns = @JoinColumn(name = "pet"))
    private Set<Pet> pets = new HashSet<>();

    @Transient
    private String[] string_pets;

    public String[] getString_pets() {
        return string_pets;
    }

    public void setString_pets(String[] string_pets) {
        this.string_pets = string_pets;
    }

    public Owner() {}

    public Owner(String fio, String number) {
        this.fio = fio;
        this.number = number;
    }

    public void clearPets() {
        pets.clear();
    }
    
    public void setPet(Pet pet) {
        pet.addOwner(this);
        pets.add(pet);
    }
    
    public void removePet(Pet pet) {
        pet.removeOwner(this);
        pets.remove(pet);
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    public Set<Pet> getPets() {
        return pets;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id: " + id + " FIO: " + fio + " number: " + number;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return id == owner.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
