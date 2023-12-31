package org.pokemons.client.pokemonclient;

import org.pokemons.client.pokemonclient.contract.dictionaries.stats.StatsListDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.stats.StatsSummaryDto;
import org.pokemons.client.pokemonclient.contract.pokemon.PokemonDto;
import org.pokemons.client.pokemonclient.contract.pokemon.PokemonListDto;
import org.pokemons.client.pokemonclient.contract.pokemon.PokemonSummaryDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class PokemonClient implements IPokemonClient {

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

    @Override
    public List<PokemonSummaryDto> getPokemons(int quantity, int nextId) {
        String url = getUrl("pokemon", settings, quantity, nextId);
        return ((PokemonListDto) getDtoListClass(PokemonListDto.class, url, restClient)).getPokemons();
    }

    @Override
    public PokemonDto getPokemon(String name) {
        String url = getUrl("pokemon", name, settings);
        return ((PokemonDto) getDtoListClass(PokemonDto.class, url, restClient));
    }

    @Override
    public List<StatsSummaryDto> getStats() {
        String url = getUrl("stat", settings);
        return ((StatsListDto) getDtoListClass(StatsListDto.class, url, restClient)).getStats();
    }
}
