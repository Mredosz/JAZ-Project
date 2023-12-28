package org.pokemons.client.pokemonclient.contract.dictionaries;

import org.pokemons.client.pokemonclient.IPokemonClient;
import org.pokemons.client.pokemonclient.IPokemonClientUrls;
import org.pokemons.client.pokemonclient.contract.dictionaries.ability.AbilityDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.ability.AbilitySummaryDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.generation.GenerationDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.generation.GenerationSummaryDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.type.TypeDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.type.TypeSummaryDto;

import java.util.List;

public interface IPokemonDictionariesClient extends IPokemonClientUrls {
    List<TypeSummaryDto> getTypes();
    List<GenerationSummaryDto> getGenerations();
    List<AbilitySummaryDto> getAbilities();
    TypeDto getType(String name);
    GenerationDto getGeneration(String name);
    AbilityDto getAbility(String name);
}
