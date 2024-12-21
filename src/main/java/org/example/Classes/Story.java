package org.example.Classes;


import jakarta.persistence.*;

@Entity
@Table(name = "story")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "history")
    private String story;
    @Column(name = "prescriptions")
    private String prescriptions;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "history")
    private Pet pet;

    public Story() {}

    public Story(String story, String prescriptions) {
        this.story = story;
        this.prescriptions = prescriptions;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        pet.setHistory(this);
        this.pet = pet;
    }

    public void removePet() {
        this.pet = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", story=" + story +
                ", prescriptions=" + prescriptions;
    }
}
