package org.example;

import org.example.Classes.Owner;
import org.example.Classes.Pet;
import org.example.Classes.Specialist;
import org.example.Classes.Story;
import org.example.Services.OwnerService;
import org.example.Services.PetService;
import org.example.Services.SpecialistService;
import org.example.Services.StoryService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        OwnerService ownerService = new OwnerService();
        SpecialistService specialistService = new SpecialistService();
        PetService petService = new PetService();
        StoryService storyService = new StoryService();

        Owner owner = new Owner("Arkhipova Arina Vyacheslavovna","89020000000");
        ownerService.insertOwner(owner);
        Specialist specialist = new Specialist("Архипова Арина Вячеславовна", "педиатр");
        specialistService.insertSpecialist(specialist);
        Pet pet = new Pet("Лайм");
        petService.insertPet(pet);
        specialist.addPet(pet);
        specialistService.updateSpecialist(specialist);
        owner.setPet(pet);
        ownerService.updateOwner(owner);
        Story story = new Story("здоров", "витамины");
        storyService.insertStory(story);
        pet.setHistory(story);
        petService.updatePet(pet);
        owner.setNumber("89030000000");
        ownerService.updateOwner(owner);
    }
}
