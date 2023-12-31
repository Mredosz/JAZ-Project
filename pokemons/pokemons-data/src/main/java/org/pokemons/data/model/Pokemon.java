package org.pokemons.data.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sourceId;
    private int weight;
    private int height;
    private String name;
    @OneToOne
    private Image image;
    @OneToOne
    private Generation generation;
    @ManyToMany(mappedBy = "pokemons")
    private List<AbilityFromPokemon> abilities = new ArrayList<>();
    @ManyToMany(mappedBy = "pokemons")
    private List<TypeFromPokemon> types = new ArrayList<>();
    @ManyToMany(mappedBy = "pokemons")
    private List<StatsFromPokemon> stats = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<AbilityFromPokemon> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilityFromPokemon> abilities) {
        this.abilities = abilities;
    }

    public List<TypeFromPokemon> getTypes() {
        return types;
    }

    public void setTypes(List<TypeFromPokemon> types) {
        this.types = types;
    }

    public List<StatsFromPokemon> getStats() {
        return stats;
    }

    public void setStats(List<StatsFromPokemon> stats) {
        this.stats = stats;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceIid) {
        this.sourceId = sourceIid;
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
}
