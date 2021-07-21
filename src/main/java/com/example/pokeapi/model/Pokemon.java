package com.example.pokeapi.model;

// id,identifier,species_id,height,weight,base_experience,order,is_default

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
public class Pokemon {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String identifier;
    private int speciesId;
    private int height;
    private int weight;
    private int baseExperience;
    @Column(name = "_ORDER")
    private int order;
    private int isDefault;
}

