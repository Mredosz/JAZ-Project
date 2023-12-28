package org.pokemons.data.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sourceId;
    private String name;
    @ManyToOne
    private DamageRelations damageRelations;
    @ManyToMany
    private List<PokemonFromType> pokemons;

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

    public DamageRelations getDamageRelations() {
        return damageRelations;
    }

    public void setDamageRelations(DamageRelations damageRelations) {
        this.damageRelations = damageRelations;
    }

    public List<PokemonFromType> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<PokemonFromType> pokemons) {
        this.pokemons = pokemons;
    }
}
