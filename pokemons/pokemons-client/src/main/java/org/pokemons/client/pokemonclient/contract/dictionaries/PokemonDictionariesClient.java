package org.pokemons.client.pokemonclient.contract.dictionaries;

import org.pokemons.client.pokemonclient.IPokemonClientSettings;
import org.pokemons.client.pokemonclient.contract.dictionaries.ability.AbilityDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.ability.AbilityListDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.ability.AbilitySummaryDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.generation.GenerationDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.generation.GenerationListDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.generation.GenerationSummaryDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.type.TypeDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.type.TypeListDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.type.TypeSummaryDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class PokemonDictionariesClient implements IPokemonDictionariesClient {
    private final IPokemonClientSettings settings;
    private RestClient restClient;

    public PokemonDictionariesClient(IPokemonClientSettings settings) {
        this.settings = settings;
        restClient = RestClient.create();
    }

    public List<TypeSummaryDto> getTypes() {
        String url = getUrl("type", settings);
        return ((TypeListDto) getDtoListClass(TypeListDto.class, url, restClient)).getType();
    }

    @Override
    public List<GenerationSummaryDto> getGenerations() {
        String url = getUrl("generation", settings);
        return ((GenerationListDto) getDtoListClass(GenerationListDto.class, url, restClient)).getGenerations();
    }

    @Override
    public List<AbilitySummaryDto> getAbilities() {
        String url = getUrl("ability", settings);
        return ((AbilityListDto) getDtoListClass(AbilityListDto.class, url, restClient)).getAbilities();
    }

    public TypeDto getType(String name) {
        String url = getUrl("type", name, settings);
        return ((TypeDto) getDtoListClass(TypeDto.class, url, restClient));
    }

    public GenerationDto getGeneration(String name) {
        String url = getUrl("generation", name, settings);
        return ((GenerationDto) getDtoListClass(GenerationDto.class, url, restClient));
    }

    public AbilityDto getAbility(String name) {
        String url = getUrl("ability", name, settings);
        return ((AbilityDto) getDtoListClass(AbilityDto.class, url, restClient));
    }
}