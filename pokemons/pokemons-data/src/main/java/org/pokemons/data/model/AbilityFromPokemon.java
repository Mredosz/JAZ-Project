package org.pokemons.data.model;

import jakarta.persistence.*;

@Entity
public class AbilityFromPokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int slot;
    @ManyToOne
    private Ability ability;

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

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
}
