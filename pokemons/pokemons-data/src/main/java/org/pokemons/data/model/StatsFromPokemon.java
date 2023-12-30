package org.pokemons.data.model;

import jakarta.persistence.*;

@Entity
public class StatsFromPokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int baseStat;
    private int effort;
    @ManyToOne
    private Stats stats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}
