package org.pokemons.updater.mapper;

import org.pokemons.client.pokemonclient.contract.dictionaries.type.TypeDto;
import org.pokemons.data.model.PokemonFromType;
import org.springframework.stereotype.Component;

@Component
public class PokemonFromTypeMapper implements IMap<TypeDto.PokemonFromTypeDto, PokemonFromType> {
    @Override
    public PokemonFromType toEntity(TypeDto.PokemonFromTypeDto pokemonFromTypeDto) {
        PokemonFromType pokemon = new PokemonFromType();
        return pokemon;
    }
}
