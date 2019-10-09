package com.checkpoint4.wildcircus.controllers;

import com.checkpoint4.wildcircus.entities.Person;
import com.checkpoint4.wildcircus.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController{

        @Autowired
        PersonRepository personRepository;
        
        @PostMapping("/persons")
            public Person store(@ModelAttribute Person person) {
                return personRepository.save(person);
            }
}