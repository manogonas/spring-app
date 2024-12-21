package org.example.Controllers;

import org.example.Classes.*;
import org.example.Services.PetService;
import org.example.Services.StoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/story")
public class StoryController {
    StoryService storyService = new StoryService();
    PetService petService = new PetService();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(ModelMap model) {
        List<Story> storiesList = storyService.findAllStories();
        model.addAttribute("stories", storiesList);
        return new ModelAndView("story");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView CreateStory(ModelMap model) {
        List<Pet> pets = petService.findAllPets();
        model.addAttribute("RadiobuttonItems", pets);
        model.addAttribute("story", new Story());
        return new ModelAndView("story_create");
    }

    @RequestMapping(value = "/addStory", method = RequestMethod.POST)
    public String AddStory(@ModelAttribute("story") Story story, ModelMap model) {
        if (story.getPet() != null) {
            String regex = "^id: (\\d+) .*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(story.getPet().getName());
            matcher.find();
            Pet p = petService.findPet(Integer.parseInt(matcher.group(1)));
            storyService.insertStory(story);
            story.setPet(p);
            petService.updatePet(p);
            storyService.updateStory(story);
        }
        else {
            storyService.insertStory(story);
        }
        List<Story> storiesList = storyService.findAllStories();
        model.addAttribute("stories", storiesList);
        return "story";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView GetStory(ModelMap model) {
        model.addAttribute("story", new Story());
        return new ModelAndView("story_get");
    }

    @RequestMapping(value = "/searchStory", method = RequestMethod.POST)
    public String SearchStory(@ModelAttribute("story") Story story, ModelMap model) {
        model.addAttribute("result", storyService.findStory(story.getId()));
        model.addAttribute("title", "Story Info");
        model.addAttribute("thing", "Story found");
        return "success_page";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView UpdateStory(ModelMap model) {
        model.addAttribute("story", new Story());
        return new ModelAndView("story_update");
    }

    @RequestMapping(value = "/updateStory", method = RequestMethod.POST)
    public String UpStory(@ModelAttribute("story") Story story, ModelMap model) {
        Story s = storyService.findStory(story.getId());
        s.setStory(story.getStory());
        s.setPrescriptions(story.getPrescriptions());
        storyService.updateStory(s);
        List<Story> storiesList = storyService.findAllStories();
        model.addAttribute("stories", storiesList);
        return "story";
    }

    @RequestMapping(value = "/add-pet", method = RequestMethod.GET)
    public ModelAndView TiePet(ModelMap model) {
        model.addAttribute("pet_story", new Pet_story());
        return new ModelAndView("story_add_pet");
    }

    @RequestMapping(value = "/addPet", method = RequestMethod.POST)
    public String UpStory(@ModelAttribute("pet_story") Pet_story ps, ModelMap model) {
        Story s = storyService.findStory(ps.getStory_id());
        s.setPet(petService.findPet(ps.getPet_id()));
        storyService.updateStory(s);
        List<Story> storiesList = storyService.findAllStories();
        model.addAttribute("stories", storiesList);
        return "story";
    }

    @RequestMapping(value= "/delete", method = RequestMethod.GET)
    public ModelAndView SearchAndDelete(ModelMap model) {
        model.addAttribute("story", new Story());
        return new ModelAndView("story_delete");
    }

    @RequestMapping(value = "/deleteStory", method = RequestMethod.POST)
    public String DeleteStory(@ModelAttribute("story") Story st, ModelMap model) {
        Story s = storyService.findStory(st.getId());
        if (s.getPet() != null) {
            Pet p = s.getPet();
            p.removeHistory();
            petService.updatePet(p);
            s.removePet();
        }
        storyService.updateStory(s);
        storyService.deleteStory(s);
        List<Story> storiesList = storyService.findAllStories();
        model.addAttribute("stories", storiesList);
        return "story";
    }

    @RequestMapping(value = "/remove-pet", method = RequestMethod.GET)
    public ModelAndView UntiePet(ModelMap model) {
        model.addAttribute("pet_story", new Pet_story());
        return new ModelAndView("story_delete_pet");
    }

    @RequestMapping(value = "/removePet", method = RequestMethod.POST)
    public String MinusPetStory(@ModelAttribute("pet_story") Pet_story ps, ModelMap model) {
        Story s = storyService.findStory(ps.getStory_id());
        Pet p = petService.findPet(ps.getPet_id());
        s.removePet();
        p.removeHistory();
        storyService.updateStory(s);
        petService.updatePet(p);
        List<Story> storiesList = storyService.findAllStories();
        model.addAttribute("stories", storiesList);
        return "story";
    }
}
