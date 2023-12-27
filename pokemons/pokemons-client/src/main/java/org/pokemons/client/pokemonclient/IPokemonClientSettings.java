package org.pokemons.client.pokemonclient;

import org.springframework.web.util.UriComponentsBuilder;

public interface IPokemonClientSettings {

    String getBaseUrl();

    String getApiVersion();

    default UriComponentsBuilder getUrl() {
        return UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host(getBaseUrl())
                .pathSegment(getApiVersion());
    }
}
