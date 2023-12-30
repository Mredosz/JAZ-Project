package org.pokemons.updater.mapper;

import org.pokemons.client.pokemonclient.contract.pokemon.PokemonDto;
import org.pokemons.data.model.TypeFromPokemon;
import org.springframework.stereotype.Component;

@Component
public class TypeFromPokemonMapper implements IMap<PokemonDto.TypeFromPokemonDto, TypeFromPokemon> {
    @Override
    public TypeFromPokemon toEntity(PokemonDto.TypeFromPokemonDto typeFromPokemonDto) {
        TypeFromPokemon type = new TypeFromPokemon();
        type.setSlot(typeFromPokemonDto.getSlot());
        return type;
    }
}
