package org.pokemons.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PokemonFromType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    private Pokemon pokemon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Pokemon getPokemon() {
//        return pokemon;
//    }
//
//    public void setPokemon(Pokemon pokemon) {
//        this.pokemon = pokemon;
//    }
}
