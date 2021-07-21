package com.example.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

