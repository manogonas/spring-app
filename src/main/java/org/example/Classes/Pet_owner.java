package org.example.Classes;

import jakarta.persistence.*;

public class Pet_owner {
    private int owner_id;
    private int pet_id;

    public int getOwner_id() {
        return owner_id;
    }

    public int getPet_id() {
        return pet_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }
}
