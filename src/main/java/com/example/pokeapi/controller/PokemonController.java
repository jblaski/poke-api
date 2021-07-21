package com.example.pokeapi.controller;

import com.example.pokeapi.model.Pokemon;
import com.example.pokeapi.repository.PokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pokemon")
@Slf4j
public class PokemonController {

    @Autowired
    PokemonRepository pokemonRepository;

    @GetMapping(path = "/{id}", produces = "application/json")
    public Pokemon getBook(@PathVariable int id) {
        Pokemon byId = pokemonRepository.getById(id);
        log.info("Found {}", byId);
        return byId;
    }

}