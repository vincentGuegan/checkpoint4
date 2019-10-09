package com.checkpoint4.wildcircus.controllers;

import java.util.List;

import com.checkpoint4.wildcircus.entities.Spectacle;
import com.checkpoint4.wildcircus.repositories.SpectacleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpectacleController{

        @Autowired
        SpectacleRepository spectacleRepository;
        
        @GetMapping("/spectacles")
        public List<Spectacle> browse() {
            return spectacleRepository.findAll();
        }

        @GetMapping("/spectacles/{id}")
        public Spectacle read(@PathVariable Long id) {
            return spectacleRepository.findById(id).get();
        }

        @PostMapping("/spectacles")
        public Spectacle store(@ModelAttribute Spectacle spectacle) {
            return spectacleRepository.save(spectacle);
        }
}