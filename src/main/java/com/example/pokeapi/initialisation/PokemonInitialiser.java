package com.example.pokeapi.initialisation;

import com.example.pokeapi.model.Pokemon;
import com.example.pokeapi.repository.PokemonRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.LinkedList;
import java.util.List;

//TODO may as well be a static utility class

@Getter
@Slf4j
public class PokemonInitialiser {

    private final List<Pokemon> scannedObjects;
    private final static String expectedHeaders = "id,identifier,species_id,height,weight,base_experience,order,is_default";

    public PokemonInitialiser(String path) {
        scannedObjects = new LinkedList<>();
        try {
            LineNumberReader lnr = new LineNumberReader(new FileReader(path));
            String headersFound = lnr.readLine();// read the header
            if (!headersFound.equals(expectedHeaders)) {
                log.error("Headers were {}, but should be {}", headersFound, expectedHeaders);
            } else {
                log.info("Found expected headers of {}", expectedHeaders);
            }
            lnr.lines().forEach(line -> {
                String[] split = line.split(",");
                try {
                    scannedObjects.add(Pokemon.builder()
                            .id(Integer.parseInt(split[0]))
                            .identifier(split[1])
                            .speciesId(Integer.parseInt(split[2]))
                            .height(Integer.parseInt(split[3]))
                            .weight(Integer.parseInt(split[4]))
                            .baseExperience(Integer.parseInt(split[5]))
                            .order(Integer.parseInt(split[6]))
                            .isDefault(Integer.parseInt(split[7]))
                            .build()
                    );
                } catch (Exception e) {
                    log.error("Error parsing line", e);
                }
            });
        } catch (IOException e) {
            log.warn("Error reading lines from file {}: {}", path, e);
        }
    }

    public void saveScannedObjects(PokemonRepository pokemonRepository) {
        log.info("Started saving {} pokemon...", scannedObjects.size());
        scannedObjects.forEach(pokemonRepository::save);
        log.info("...finished saving {} pokemon.", scannedObjects.size());
    }
}
