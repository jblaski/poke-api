package com.example.pokeapi;

import com.example.pokeapi.model.Pokemon;
import com.example.pokeapi.repository.PokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Optional;

@Slf4j
@SpringBootApplication
public class PokeApiApplication {

	@Autowired
	PokemonRepository pokemonRepository;

	public static void main(String[] args) {
		SpringApplication.run(PokeApiApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void afterStartup() {
		log.info("Spring has started!");

		Pokemon bulbasaur = Pokemon.builder()
				.id(1)
				.identifier("bulbasaur")
				.speciesId(1)
				.height(7)
				.weight(69)
				.baseExperience(64)
				.order(1)
				.isDefault(1)
				.build();

		pokemonRepository.save(bulbasaur);
		Optional<Pokemon> byId = pokemonRepository.findById(1);
		byId.ifPresent(pokemon -> {
			log.info(pokemon.toString());
		});

	}

}
