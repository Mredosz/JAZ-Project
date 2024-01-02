package org.pokemons.client.pokemonclient;

import org.springframework.web.client.RestClient;

public interface IPokemonClientUrls {
    default String getUrl(String pathSegments, IPokemonClientSettings settings) {
        return settings.getUrl()
                .pathSegment(pathSegments)
                .queryParam("limit", 400)
                .build()
                .toUriString();
    }

    default String getUrl(String pathSegments, IPokemonClientSettings settings, int quantity, int nextId) {
        return settings.getUrl()
                .pathSegment(pathSegments)
                .queryParam("limit", quantity)
                .queryParam("offset", nextId)
                .build()
                .toUriString();
    }

    default String getUrl(String pathSegments, String name, IPokemonClientSettings settings) {
        return settings.getUrl()
                .pathSegment(pathSegments)
                .pathSegment(name)
                .build()
                .toUriString();
    }

    default String getUrl(String pathSegments, String name, IPokemonClientSettings settings, int quantity) {
        return settings.getUrl()
                .pathSegment(pathSegments)
                .pathSegment(name)
                .build()
                .toUriString();
    }

    default <T> Object getDtoListClass(Class<T> clazz, String url, RestClient restClient) {
        return restClient
                .get()
                .uri(url)
                .retrieve()
                .body(clazz);
    }
}