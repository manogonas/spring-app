package org.example.Services;

import org.example.DAO.PetDAO;
import org.example.Classes.Pet;

import java.util.ArrayList;

public class PetService {

    private PetDAO petsDao = new PetDAO();

    public PetService() {
    }

    public Pet findPet(int id) {
        return petsDao.findById(id);
    }

    public void insertPet(Pet Pet) {
        petsDao.insert(Pet);
    }

    public void deletePet(Pet Pet) {
        petsDao.delete(Pet);
    }

    public void updatePet(Pet Pet) {
        petsDao.update(Pet);
    }

    public ArrayList<Pet> findAllPets() {
        return petsDao.findAll();
    }
}
