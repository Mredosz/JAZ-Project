package org.pokemons.updater.mapper;

import org.pokemons.client.pokemonclient.contract.pokemon.PokemonDto;
import org.pokemons.data.model.Pokemon;
import org.springframework.stereotype.Component;

@Component
public class PokemonMapper implements IMap<PokemonDto, Pokemon> {
    @Override
    public Pokemon toEntity(PokemonDto pokemonDto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setHeight(pokemonDto.getHeight());
        pokemon.setWeight(pokemonDto.getWeight());
        pokemon.setSourceId(pokemonDto.getSourceId());
        pokemon.setName(pokemonDto.getName());
        return pokemon;
    }
}
