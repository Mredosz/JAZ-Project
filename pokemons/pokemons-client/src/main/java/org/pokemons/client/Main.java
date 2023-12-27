package org.pokemons.client;

import org.pokemons.client.pokemonclient.PokemonClientSettings;
import org.pokemons.client.pokemonclient.PokemonDictionariesClient;

public class Main {

    public static void main(String[] args) {
        getList(new PokemonDictionariesClient(new PokemonClientSettings("pokeapi.co/api","v2")));
    }

    public static void getList(PokemonDictionariesClient pokemonClient){
        var abilities = pokemonClient.getAbilities();
        var generations = pokemonClient.getGenerations();
        var types = pokemonClient.getTypes();
        var type = pokemonClient.getType();

        for (var test : abilities){
            System.out.println(test);
        }
    }
}
