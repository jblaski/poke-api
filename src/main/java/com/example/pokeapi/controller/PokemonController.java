package com.example.pokeapi.controller;

import com.example.pokeapi.model.Pokemon;
import com.example.pokeapi.repository.PokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("pokemon")
@Slf4j
public class PokemonController {

    @Autowired
    PokemonRepository pokemonRepository;

    @GetMapping(path = "/{id}", produces = "application/json")
    public Pokemon getPokemon(@PathVariable int id) {
        Pokemon byId = pokemonRepository.getById(id);
        log.info("Found {}", byId);
        return byId;
    }

    @GetMapping("")
    @ResponseBody
    public Pokemon paramMap(@RequestParam Map<String,String> allParams) {
        String identifier = allParams.get("identifier");
        return pokemonRepository.findByIdentifier(identifier);
    }

}