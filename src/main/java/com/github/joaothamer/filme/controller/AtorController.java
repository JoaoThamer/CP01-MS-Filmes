package com.github.joaothamer.filme.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ator")
public class AtorController {

    @GetMapping("/adam")
    public String adam(){
        return "Adam Sandler";
    }
}
