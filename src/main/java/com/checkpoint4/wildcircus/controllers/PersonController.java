package com.checkpoint4.wildcircus.controllers;

import java.util.List;

import javax.validation.Valid;

import com.checkpoint4.wildcircus.entities.Person;
import com.checkpoint4.wildcircus.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public String browse(Model model) {
        List<Person> personList = personRepository.findAll();
        model.addAttribute("personList", personList);
        return "index";
    }

    @GetMapping("/persons/{id}")
    public String read(Model model, @PathVariable Long id) {
        Person person = personRepository.findById(id).get();
        model.addAttribute("person", person);
        return "index";
    }

    @PostMapping("/persons")
    public String store(@Valid Person person) {
        person = personRepository.save(person);
        return "redirect:/persons/" + person.getId();
    }
}
