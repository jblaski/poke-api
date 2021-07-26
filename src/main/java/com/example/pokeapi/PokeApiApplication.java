package com.example.pokeapi;

import com.example.pokeapi.initialisation.PokemonInitialiser;
import com.example.pokeapi.model.Pokemon;
import com.example.pokeapi.repository.PokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootApplication
public class PokeApiApplication {

	@Autowired
	private PokemonRepository pokemonRepository;

	public static void main(String[] args) {
		SpringApplication.run(PokeApiApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void afterStartup() {
		PokemonInitialiser.loadAndSave("data/pokemon.csv", pokemonRepository);
	}

}
