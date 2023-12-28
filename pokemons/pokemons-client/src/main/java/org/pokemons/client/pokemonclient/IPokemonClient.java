package org.pokemons.client.pokemonclient;

import org.pokemons.client.pokemonclient.contract.PokemonDto;
import org.pokemons.client.pokemonclient.contract.PokemonSummaryDto;

import java.util.List;

public interface IPokemonClient extends IPokemonClientUrls{
    List<PokemonSummaryDto> getPokemons(int quantity);
    PokemonDto getPokemon(String name);
}
