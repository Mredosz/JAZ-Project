package org.pokemons.client.pokemonclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PokemonClientSettings implements IPokemonClientSettings {
    private String baseUrl;
    private String apiVersion;

    public PokemonClientSettings(
            @Value("${poke.api.host}") String baseUrl,
            @Value("${poke.api.version}")String apiVersion) {
        this.baseUrl = baseUrl;
        this.apiVersion = apiVersion;
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public String getApiVersion() {
        return apiVersion;
    }
}
