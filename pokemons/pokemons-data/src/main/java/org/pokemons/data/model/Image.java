package org.pokemons.data.model;

import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;
//    @OneToOne
//    private Pokemon pokemon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public Pokemon getPokemon() {
//        return pokemon;
//    }
//
//    public void setPokemon(Pokemon pokemon) {
//        this.pokemon = pokemon;
//    }
}
