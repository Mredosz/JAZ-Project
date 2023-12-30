package org.pokemons.updater.mapper;

import org.pokemons.client.pokemonclient.contract.pokemon.PokemonDto;
import org.pokemons.data.model.AbilityFromPokemon;
import org.springframework.stereotype.Component;

@Component
public class AbilityFromPokemonMapper implements IMap<PokemonDto.AbilityFromPokemonDto, AbilityFromPokemon> {
    @Override
    public AbilityFromPokemon toEntity(PokemonDto.AbilityFromPokemonDto abilityFromPokemonDto) {
        AbilityFromPokemon ability = new AbilityFromPokemon();
        ability.setSlot(abilityFromPokemonDto.getSlot());
        return ability;
    }
}
