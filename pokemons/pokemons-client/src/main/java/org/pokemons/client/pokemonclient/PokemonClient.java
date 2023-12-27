package org.pokemons.client.pokemonclient;

import org.pokemons.client.pokemonclient.contract.dictionaries.TypeListDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.TypeSummaryDto;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class PokemonClient implements IPokemonClient{

    private RestClient restClient;
    private final IPokemonClientSettings settings;

    String apiVersion;
    String baseUrl;

    public PokemonClient(IPokemonClientSettings settings) {
        this.restClient = RestClient.create();
        this.settings = settings;
        this.apiVersion = settings.getApiVersion();
        this.baseUrl = settings.getBaseUrl();
    }

}
