package com.checkpoint4.wildcircus.controllers;

import javax.validation.Valid;

import com.checkpoint4.wildcircus.entities.Person;
import com.checkpoint4.wildcircus.entities.Spectacle;
import com.checkpoint4.wildcircus.repositories.PersonRepository;
import com.checkpoint4.wildcircus.repositories.SpectacleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
class BookingController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SpectacleRepository spectacleRepository;

    @GetMapping("/booking")
    public String browse(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("spectacles", spectacleRepository.findAll());
        return "booking";
    }

    @PostMapping("/booking")
    public String store(@Valid Person person, @Valid Spectacle spectacle) {
        person.getSubscribedSpectacles().add(spectacle);
        person = personRepository.save(person);
        return "redirect:/index";
    }
}
