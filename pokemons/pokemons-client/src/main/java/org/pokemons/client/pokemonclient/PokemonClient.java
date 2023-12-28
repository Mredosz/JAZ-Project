package org.pokemons.client.pokemonclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

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
