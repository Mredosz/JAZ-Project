package org.pokemons.client.pokemonclient;

import org.pokemons.client.pokemonclient.contract.dictionaries.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
@Component
public class PokemonDictionariesClient implements IPokemonDictionariesClient{
    private final IPokemonClientSettings settings;
    private RestClient restClient;

    public PokemonDictionariesClient(IPokemonClientSettings settings) {
        this.settings = settings;
        restClient = RestClient.create();
    }

    public List<TypeSummaryDto> getTypes(){
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
        return ((AbilityListDto) getDtoListClass(AbilityListDto.class,url)).getAbilities();
    }

    public TypeDto getType(){
        String url =  settings.getUrl()
                .pathSegment("type")
                .pathSegment("1")
                .build()
                .toUriString();
        return ((TypeDto) getDtoListClass(TypeDto.class, url));
    }

    private String getUrl(String pathSegments){
        return settings.getUrl()
                .pathSegment(pathSegments)
                .queryParam("limit",400)
                .build()
                .toUriString();
    }

    private <T> Object getDtoListClass(Class<T> clazz, String url){
        return restClient
                .get()
                .uri(url)
                .retrieve()
                .body(clazz);
    }
}
