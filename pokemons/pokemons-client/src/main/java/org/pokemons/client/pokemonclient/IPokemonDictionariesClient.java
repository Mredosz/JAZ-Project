package org.pokemons.client.pokemonclient;

import org.pokemons.client.pokemonclient.contract.dictionaries.AbilitySummaryDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.GenerationSummaryDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.TypeSummaryDto;

import java.util.List;

public interface IPokemonDictionariesClient {
    List<TypeSummaryDto> getTypes();
    List<GenerationSummaryDto> getGenerations();
    List<AbilitySummaryDto> getAbilities();

}
