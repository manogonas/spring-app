package org.example.Controllers;

import org.example.Classes.Owner;
import org.example.Classes.Pet;
import org.example.Classes.Pet_owner;
import org.example.Services.OwnerService;
import org.example.Services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/owner")
public class OwnerController {
    OwnerService ownerService = new OwnerService();
    PetService petService = new PetService();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(ModelMap model) {
        List<Owner> ownerList = ownerService.findAllOwners();
        model.addAttribute("owners", ownerList);
        return new ModelAndView("owner");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView CreateOwner(ModelMap model) {
        List<Pet> petList = petService.findAllPets();
        model.addAttribute("checkboxOptions", petList);
        model.addAttribute("owner", new Owner());
        return new ModelAndView("owner_create");
    }

    @RequestMapping(value = "/addOwner", method = RequestMethod.POST)
    public String AddOwner(@Valid @ModelAttribute("owner") Owner owner,
                           BindingResult bindingResult, ModelMap model) {
        System.out.println(bindingResult.hasErrors());
        if (bindingResult.hasErrors()) {
            List<Pet> petList = petService.findAllPets();
            model.addAttribute("checkboxOptions", petList);
            return "owner_create";
        }
        ownerService.insertOwner(owner);
        if (owner.getString_pets() != null) {
            String regex = "^id: (\\d+) .*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher;
            Pet pet;
            for (String p : owner.getString_pets()) {
                System.out.println("p " + p);
                matcher = pattern.matcher(p);
                matcher.find();
                pet = petService.findPet(Integer.parseInt(matcher.group(1)));
                owner.setPet(pet);
                petService.updatePet(pet);
            }
        }
        List<Owner> ownerList = ownerService.findAllOwners();
        model.addAttribute("owners", ownerList);
        return "owner";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView GetOwner(ModelMap model) {
        model.addAttribute("owner", new Owner());
        return new ModelAndView("owner_get");
    }

    @RequestMapping(value = "/searchOwner", method = RequestMethod.POST)
    public String SearchOwner(@ModelAttribute("owner") Owner owner, ModelMap model) {
        model.addAttribute("result", ownerService.findOwner(owner.getId()));
        model.addAttribute("title", "Owner Info");
        model.addAttribute("thing", "Owner found");
        return "success_page";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView UpdateOwner(ModelMap model) {
        model.addAttribute("owner", new Owner());
        return new ModelAndView("owner_update");
    }

    @RequestMapping(value = "/updateOwner", method = RequestMethod.POST)
    public String UpOwner(@ModelAttribute("owner") Owner owner, ModelMap model) {
        Owner ow = ownerService.findOwner(owner.getId());
        ow.setFio(owner.getFio());
        ow.setNumber(owner.getNumber());
        ownerService.updateOwner(ow);
        List<Owner> ownerList = ownerService.findAllOwners();
        model.addAttribute("owners", ownerList);
        return "owner";
    }

    @RequestMapping(value = "/add-pet", method = RequestMethod.GET)
    public ModelAndView TiePet(ModelMap model) {
        model.addAttribute("pet_owner", new Pet_owner());
        return new ModelAndView("owner_add_pet");
    }

    @RequestMapping(value = "/addPet", method = RequestMethod.POST)
    public String UpOwner(@ModelAttribute("pet_owner") Pet_owner po, ModelMap model) {
        Owner o = ownerService.findOwner(po.getOwner_id());
        o.setPet(petService.findPet(po.getPet_id()));
        ownerService.updateOwner(o);
        List<Owner> ownerList = ownerService.findAllOwners();
        model.addAttribute("owners", ownerList);
        return "owner";
    }

    @RequestMapping(value= "/delete", method = RequestMethod.GET)
    public ModelAndView SearchAndDelete(ModelMap model) {
        model.addAttribute("owner", new Owner());
        return new ModelAndView("owner_delete");
    }

    @RequestMapping(value = "/deleteOwner", method = RequestMethod.POST)
    public String DeleteOwner(@ModelAttribute("owner") Owner ow, ModelMap model) {
        Owner o = ownerService.findOwner(ow.getId());
        if (o.getPets() != null) {
            Set<Pet> pets = o.getPets();
            for (Pet p : pets) {
                p.removeOwner(o);
                petService.updatePet(p);
            }
            o.clearPets();
            ownerService.updateOwner(o);
            ownerService.deleteOwner(o);
        }
        List<Owner> ownerList = ownerService.findAllOwners();
        model.addAttribute("owners", ownerList);
        return "owner";
    }

    @RequestMapping(value = "/remove-pet", method = RequestMethod.GET)
    public ModelAndView UntiePet(ModelMap model) {
        model.addAttribute("pet_owner", new Pet_owner());
        return new ModelAndView("owner_delete_pet");
    }

    @RequestMapping(value = "/removePet", method = RequestMethod.POST)
    public String MinusPetOwner(@ModelAttribute("pet_owner") Pet_owner po, ModelMap model) {
        Owner o = ownerService.findOwner(po.getOwner_id());
        Pet p = petService.findPet(po.getPet_id());
        o.removePet(p);
        ownerService.updateOwner(o);
        List<Owner> ownerList = ownerService.findAllOwners();
        model.addAttribute("owners", ownerList);
        return "owner";
    }
}
