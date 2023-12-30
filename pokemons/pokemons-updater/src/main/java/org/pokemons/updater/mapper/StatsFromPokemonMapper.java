package org.pokemons.updater.mapper;

import org.pokemons.client.pokemonclient.contract.pokemon.PokemonDto;
import org.pokemons.data.model.StatsFromPokemon;
import org.springframework.stereotype.Component;

@Component
public class StatsFromPokemonMapper implements IMap<PokemonDto.StatsFromPokemonDto, StatsFromPokemon> {
    @Override
    public StatsFromPokemon toEntity(PokemonDto.StatsFromPokemonDto statsFromPokemonDto) {
        StatsFromPokemon stats = new StatsFromPokemon();
        stats.setBaseStat(statsFromPokemonDto.getBaseStat());
        stats.setEffort(statsFromPokemonDto.getEffort());
        return stats;
    }
}
