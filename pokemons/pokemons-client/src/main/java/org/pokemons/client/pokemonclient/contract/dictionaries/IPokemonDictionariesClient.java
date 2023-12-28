package org.pokemons.client.pokemonclient.contract.dictionaries;

import org.pokemons.client.pokemonclient.contract.dictionaries.ability.AbilitySummaryDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.generation.GenerationSummaryDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.type.TypeSummaryDto;

import java.util.List;

public interface IPokemonDictionariesClient {
    List<TypeSummaryDto> getTypes();
    List<GenerationSummaryDto> getGenerations();
    List<AbilitySummaryDto> getAbilities();

}
