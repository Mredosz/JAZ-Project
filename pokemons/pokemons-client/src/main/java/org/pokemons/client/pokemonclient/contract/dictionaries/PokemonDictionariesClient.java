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
        String url = getUrl("type");
        return ((TypeListDto) getDtoListClass(TypeListDto.class, url)).getType();
    }

    @Override
    public List<GenerationSummaryDto> getGenerations() {
        String url = getUrl("generation");
        return ((GenerationListDto) getDtoListClass(GenerationListDto.class, url)).getGenerations();
    }

    @Override
    public List<AbilitySummaryDto> getAbilities() {
        String url = getUrl("ability");
        return ((AbilityListDto) getDtoListClass(AbilityListDto.class, url)).getAbilities();
    }

    public TypeDto getType(String name) {
        String url = getUrl("type", name);
        return ((TypeDto) getDtoListClass(TypeDto.class, url));
    }

    public GenerationDto getGeneration(String name) {
        String url = getUrl("generation", name);
        return ((GenerationDto) getDtoListClass(GenerationDto.class, url));
    }

    public AbilityDto getAbility(String name) {
        String url = getUrl("ability", name);
        return ((AbilityDto) getDtoListClass(AbilityDto.class, url));
    }

    private String getUrl(String pathSegments) {
        return settings.getUrl()
                .pathSegment(pathSegments)
                .queryParam("limit", 400)
                .build()
                .toUriString();
    }

    private String getUrl(String pathSegments, String name) {
        return settings.getUrl()
                .pathSegment(pathSegments)
                .pathSegment(name)
                .queryParam("limit", 400)
                .build()
                .toUriString();
    }

    private <T> Object getDtoListClass(Class<T> clazz, String url) {
        return restClient
                .get()
                .uri(url)
                .retrieve()
                .body(clazz);
    }
}
