package org.pokemons.data.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sourceId;
    private String name;
    @ManyToOne
    private Generation generation;
    @ManyToMany
    private List<PokemonFromAbility> pokemon;
}
