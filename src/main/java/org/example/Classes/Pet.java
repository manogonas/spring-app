package org.example.Classes;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "specialist")
    private Specialist specialist;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name = "story")
    private Story history;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "pets")
    //@JoinTable(name = "pet_owner", joinColumns = @JoinColumn(name = "pet"),
            //inverseJoinColumns = @JoinColumn(name = "owner"))
    private Set<Owner> owners = new HashSet<>();

    public Pet() {}

    public Pet(String name) {
        this.name = name;
    }

    public void addOwner(Owner owner) {
        owners.add(owner);
    }

    public void removeOwner(Owner owner) {
        owners.remove(owner);
    }

    public void removeSpecialist() {
            this.specialist = null;
    }

    public void addHistory(Story story) {
        story.setPet(this);
        setHistory(story);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public Story getHistory() {
        return history;
    }

    public void setHistory(Story history) {
        this.history = history;
    }

    public Set<Owner> getOwners() {
        return owners;
    }

    @Override
    public String toString() {
        String str = "id: " + id + " name: " + name;
        return str;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return id == pet.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void removeHistory() {
        history = null;
    }

    public void clearOwners() {
        owners.clear();
    }
}
