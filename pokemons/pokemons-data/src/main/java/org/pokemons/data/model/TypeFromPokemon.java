package org.pokemons.data.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TypeFromPokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int slot;
    @ManyToOne
    private Type type;
    @ManyToMany
    @JoinTable(
            name = "pokemon_type_from_pokemon",
            joinColumns = @JoinColumn(name = "typefrompokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "pokemon_id")
    )
    List<Pokemon> pokemons = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
