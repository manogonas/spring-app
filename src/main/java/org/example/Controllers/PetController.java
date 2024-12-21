package org.example.Controllers;

import org.example.Classes.Owner;
import org.example.Classes.Pet;
import org.example.Services.OwnerService;
import org.example.Services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Controller
@RequestMapping("/pet")
public class PetController {
    PetService petService = new PetService();
    OwnerService ownerService = new OwnerService();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(ModelMap model) {
        List<Pet> petList = petService.findAllPets();
        model.addAttribute("pets", petList);
        return new ModelAndView("pet");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView CreatePet(ModelMap model) {
        model.addAttribute("pet", new Pet());
        return new ModelAndView("pet_create");
    }

    @RequestMapping(value = "/addPet", method = RequestMethod.POST)
    public String AddPet(@ModelAttribute("pet") Pet pet, ModelMap model) {
        petService.insertPet(pet);
        List<Pet> petList = petService.findAllPets();
        model.addAttribute("pets", petList);
        return "pet";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView GetPet(ModelMap model) {
        model.addAttribute("pet", new Pet());
        return new ModelAndView("pet_get");
    }

    @RequestMapping(value = "/searchPet", method = RequestMethod.POST)
    public String SearchPet(@ModelAttribute("pet") Pet pet, ModelMap model) {
        System.out.println(pet);
        model.addAttribute("result", petService.findPet(pet.getId()));
        model.addAttribute("title", "Pet Info");
        model.addAttribute("thing", "Pet found");
        return "success_page";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView UpdatePet(ModelMap model) {
        model.addAttribute("pet", new Pet());
        return new ModelAndView("pet_update");
    }

    @RequestMapping(value = "/updatePet", method = RequestMethod.POST)
    public String UpPet(@ModelAttribute("pet") Pet pet, ModelMap model) {
        Pet p = petService.findPet(pet.getId());
        p.setName(pet.getName());
        petService.updatePet(p);
        List<Pet> petList = petService.findAllPets();
        model.addAttribute("pets", petList);
        return "pet";
    }

    @RequestMapping(value= "/delete", method = RequestMethod.GET)
    public ModelAndView SearchAndDelete(ModelMap model) {
        model.addAttribute("pet", new Pet());
        return new ModelAndView("pet_delete");
    }

    @RequestMapping(value = "/deletePet", method = RequestMethod.POST)
    public String DeletePet(@ModelAttribute("pet") Pet pet, ModelMap model) {
        Pet p = petService.findPet(pet.getId());
        Set<Owner> owners =  p.getOwners();
        for (Owner o: owners) {
            o.removePet(pet);
            ownerService.updateOwner(o);
        }
        p.clearOwners();
        p.removeSpecialist();
        p.removeHistory();
        petService.updatePet(p);
        petService.deletePet(p);
        List<Pet> petList = petService.findAllPets();
        model.addAttribute("pets", petList);
        return "pet";
    }
}

