package com.checkpoint4.wildcircus.controllers;

import java.util.List;
import com.checkpoint4.wildcircus.entities.Person;
import com.checkpoint4.wildcircus.entities.Spectacle;
import com.checkpoint4.wildcircus.repositories.PersonRepository;
import com.checkpoint4.wildcircus.repositories.SpectacleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SpectacleController {

    @Autowired
    SpectacleRepository spectacleRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/spectacles")
    public String browse(Model model) {
        List<Spectacle> spectacleList = spectacleRepository.findAll();
        model.addAttribute("spectacleList", spectacleList);
        return "spectacles";
    }

    @GetMapping("/spectacles/{id}")
    public String read(Model model, @PathVariable Long id) {
        Spectacle spectacle = spectacleRepository.findById(id).get();
        model.addAttribute("spectacle", spectacle);
        return "spectacles";
    }

    @GetMapping("/spectacles/{id}/persons/{personId}")
    public String associate(@PathVariable Long id, @PathVariable Long personId) {
        Spectacle spectacle = spectacleRepository.findById(id).get();
        Person person = personRepository.findById(personId).get();

        person.getSubscribedSpectacles().add(spectacle);
        personRepository.save(person);

        return "spectacles";
    }

    @PostMapping("/spectacles")
    public String store(@ModelAttribute Spectacle spectacle) {
        spectacleRepository.save(spectacle);
        return "redirect:/spectacles/" + spectacle.getId();
    }
}