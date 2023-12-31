package org.pokemons.data.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sourceId;
    private String name;
    @ManyToMany
    private List<DamageRelations> damageRelations = new ArrayList<>();
//    @ManyToMany
//    private List<Pokemon> pokemons = new ArrayList<>();

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

    public List<DamageRelations> getDamageRelations() {
        return damageRelations;
    }

    public void setDamageRelations(List<DamageRelations> damageRelations) {
        this.damageRelations = damageRelations;
    }

//    public List<Pokemon> getPokemons() {
//        return pokemons;
//    }
//
//    public void setPokemons(List<Pokemon> pokemons) {
//        this.pokemons = pokemons;
//    }
}
