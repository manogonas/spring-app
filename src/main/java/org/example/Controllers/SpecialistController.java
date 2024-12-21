package org.example.Controllers;

import org.example.Classes.*;
import org.example.Services.PetService;
import org.example.Services.SpecialistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Controller
@RequestMapping("/specialist")
public class SpecialistController {
    SpecialistService specialistService = new SpecialistService();
    PetService petService = new PetService();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(ModelMap model) {
        List<Specialist> specialistsList = specialistService.findAllSpecialists();
        model.addAttribute("specialists", specialistsList);
        return new ModelAndView("specialist");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView CreateSpecialist(ModelMap model) {
        List<String> jobs = new ArrayList<>();
        jobs.add("priest");
        jobs.add("therapist");
        jobs.add("trainer");
        jobs.add("surgery");
        model.addAttribute("SelectItems", jobs);
        model.addAttribute("specialist", new Specialist());
        return new ModelAndView("specialist_create");
    }

    @RequestMapping(value = "/addSpecialist", method = RequestMethod.POST)
    public String AddSpecialist(@ModelAttribute("specialist") Specialist specialist, ModelMap model) {
        specialistService.insertSpecialist(specialist);
        List<Specialist> specialistsList = specialistService.findAllSpecialists();
        model.addAttribute("specialists", specialistsList);
        return "specialist";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView GetSpecialist(ModelMap model) {
        model.addAttribute("specialist", new Specialist());
        return new ModelAndView("specialist_get");
    }

    @RequestMapping(value = "/searchSpecialist", method = RequestMethod.POST)
    public String SearchSpecialist(@ModelAttribute("specialist") Specialist specialist, ModelMap model) {
        model.addAttribute("result", specialistService.findSpecialist(specialist.getId()));
        model.addAttribute("title", "Specialist Info");
        model.addAttribute("thing", "Specialist found");
        return "success_page";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView UpdateSpecialist(ModelMap model) {
        model.addAttribute("specialist", new Specialist());
        return new ModelAndView("specialist_update");
    }

    @RequestMapping(value = "/updateSpecialist", method = RequestMethod.POST)
    public String UpSpecialist(@ModelAttribute("specialist") Specialist specialist, ModelMap model) {
        Specialist s = specialistService.findSpecialist(specialist.getId());
        s.setFio(specialist.getFio());
        s.setJob(specialist.getJob());
        specialistService.updateSpecialist(s);
        List<Specialist> specialistsList = specialistService.findAllSpecialists();
        model.addAttribute("specialists", specialistsList);
        return "specialist";
    }

    @RequestMapping(value = "/add-pet", method = RequestMethod.GET)
    public ModelAndView TiePet(ModelMap model) {
        model.addAttribute("pet_specialist", new Pet_specialist());
        return new ModelAndView("specialist_add_pet");
    }

    @RequestMapping(value = "/addPet", method = RequestMethod.POST)
    public String UpSpecialist(@ModelAttribute("pet_specialist") Pet_specialist ps, ModelMap model) {
        Specialist s = specialistService.findSpecialist(ps.getSpecialist_id());
        s.setPet(petService.findPet(ps.getPet_id()));
        specialistService.updateSpecialist(s);
        List<Specialist> specialistsList = specialistService.findAllSpecialists();
        model.addAttribute("specialists", specialistsList);
        return "specialist";
    }

    @RequestMapping(value= "/delete", method = RequestMethod.GET)
    public ModelAndView SearchAndDelete(ModelMap model) {
        model.addAttribute("specialist", new Specialist());
        return new ModelAndView("specialist_delete");
    }

    @RequestMapping(value = "/deleteSpecialist", method = RequestMethod.POST)
    public String DeleteSpecialist(@ModelAttribute("specialist") Specialist sp, ModelMap model) {
        Specialist s = specialistService.findSpecialist(sp.getId());
        Set<Pet> pets =  s.getPets();
        for (Pet p: pets) {
            p.removeSpecialist();
            petService.updatePet(p);
        }
        s.clearPets();
        specialistService.updateSpecialist(s);
        specialistService.deleteSpecialist(s);
        List<Specialist> specialistsList = specialistService.findAllSpecialists();
        model.addAttribute("specialists", specialistsList);
        return "specialist";
    }

    @RequestMapping(value = "/remove-pet", method = RequestMethod.GET)
    public ModelAndView UntiePet(ModelMap model) {
        model.addAttribute("pet_specialist", new Pet_specialist());
        return new ModelAndView("specialist_delete_pet");
    }

    @RequestMapping(value = "/removePet", method = RequestMethod.POST)
    public String MinusPetSpecialist(@ModelAttribute("pet_specialist") Pet_specialist ps, ModelMap model) {
        Specialist s = specialistService.findSpecialist(ps.getSpecialist_id());
        Pet p = petService.findPet(ps.getPet_id());
        s.removePet(p);
        specialistService.updateSpecialist(s);
        petService.updatePet(p);
        List<Specialist> specialistsList = specialistService.findAllSpecialists();
        model.addAttribute("specialists", specialistsList);
        return "specialist";
    }
}
