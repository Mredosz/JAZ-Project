package org.pokemons.client;

import org.pokemons.client.pokemonclient.PokemonClient;
import org.pokemons.client.pokemonclient.PokemonClientSettings;
import org.pokemons.client.pokemonclient.contract.pokemon.PokemonDto;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        getList(new PokemonClient(new PokemonClientSettings("pokeapi.co/api","v2")));
    }

    public static void getList(PokemonClient pokemonClient){
        var pokemons = pokemonClient.getPokemons(2);
        List<PokemonDto> pokemonDtos = new ArrayList<>();
        for (var pokemon : pokemons){
            pokemonDtos.add(pokemonClient.getPokemon(pokemon.getName()));
        }
    }
}
