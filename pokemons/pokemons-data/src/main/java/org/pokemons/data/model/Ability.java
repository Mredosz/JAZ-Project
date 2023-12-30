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
    private List<Pokemon> pokemon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }
}
