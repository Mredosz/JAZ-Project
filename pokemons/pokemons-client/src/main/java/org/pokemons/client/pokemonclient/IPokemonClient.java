package org.pokemons.client.pokemonclient;

import org.pokemons.client.pokemonclient.contract.dictionaries.stats.StatsSummaryDto;
import org.pokemons.client.pokemonclient.contract.pokemon.PokemonDto;
import org.pokemons.client.pokemonclient.contract.pokemon.PokemonSummaryDto;

import java.util.List;

public interface IPokemonClient extends IPokemonClientUrls{
    List<PokemonSummaryDto> getPokemons(int quantity);
    PokemonDto getPokemon(String name);
    List<StatsSummaryDto> getStats();
}
