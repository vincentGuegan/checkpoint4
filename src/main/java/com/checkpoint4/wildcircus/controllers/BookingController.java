package com.checkpoint4.wildcircus.controllers;

import com.checkpoint4.wildcircus.entities.Person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
class BookingController {

    @GetMapping("/booking")
    public String browse(Model model) {
        model.addAttribute("person", new Person());
        return "booking";
    }
}
