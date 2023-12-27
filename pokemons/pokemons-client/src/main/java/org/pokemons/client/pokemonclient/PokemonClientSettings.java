package org.pokemons.client.pokemonclient;

//@Component
public class PokemonClientSettings implements IPokemonClientSettings {
//    @Value("${poke.api.host}")
    String baseUrl;

//    @Value("${poke.api.version}")
    String apiVersion;

    public PokemonClientSettings(String baseUrl, String apiVersion) {
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
