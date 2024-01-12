package org.pokemons.web.service;

import org.pokemons.web.contract.PokemonDto;
import org.pokemons.web.contract.PokemonSummaryDto;

import java.util.List;

public interface IPokemonService {
    List<PokemonSummaryDto> getAllPokemons();
    PokemonDto getPokemon(int id);
}
