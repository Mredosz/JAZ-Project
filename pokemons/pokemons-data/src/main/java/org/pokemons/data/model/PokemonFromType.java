package org.pokemons.data.model;

import jakarta.persistence.*;

@Entity
public class PokemonFromType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Pokemon pokemon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
