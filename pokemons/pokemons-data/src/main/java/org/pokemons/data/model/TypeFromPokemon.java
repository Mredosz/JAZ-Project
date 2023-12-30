package org.pokemons.data.model;

import jakarta.persistence.*;

@Entity
public class TypeFromPokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int slot;
    @ManyToOne
    private Type type;

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
}
