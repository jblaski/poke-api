package com.example.pokeapi.repository;

import com.example.pokeapi.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    Pokemon findByIdentifier(String identifier);
}
