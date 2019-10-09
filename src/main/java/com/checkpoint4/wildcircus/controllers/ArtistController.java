package com.checkpoint4.wildcircus.controllers;

import java.util.List;

import javax.validation.Valid;

import com.checkpoint4.wildcircus.entities.Artist;
import com.checkpoint4.wildcircus.repositories.ArtistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/artists")
    public String browse(Model model) {
        List<Artist> artistList = artistRepository.findAll();
        model.addAttribute("artistList", artistList);
        return "index";
    }

    @GetMapping("/artists/{id}")
    public String read(Model model, @PathVariable Long id) {
        Artist artist = artistRepository.findById(id).get();
        model.addAttribute("artist", artist);
        return "index";
    }

    @PostMapping("/artists")
    public String store(@Valid Artist artist) {
        artist = artistRepository.save(artist);
        return "redirect:/artists/" + artist.getId();
    }
}
