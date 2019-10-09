package com.checkpoint4.wildcircus.controllers;

import java.util.List;

import com.checkpoint4.wildcircus.entities.Person;
import com.checkpoint4.wildcircus.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController{

        @Autowired
        PersonRepository personRepository;
        
        @GetMapping("/persons")
        public List<Person> browse() {
            return personRepository.findAll();
        }

        @GetMapping("/persons/{id}")
        public Person read(@PathVariable Long id) {
            return personRepository.findById(id).get();
        }
        
        @PostMapping("/persons")
        public Person store(@ModelAttribute Person person) {
            return personRepository.save(person);
        }

       // @DeleteMapping("/persons")
       // public void destroy(@PathVariable Long id) {
        //    personRepository.delete(
          //      personRepository.findById(id).get()
       //     );
      //  }
}