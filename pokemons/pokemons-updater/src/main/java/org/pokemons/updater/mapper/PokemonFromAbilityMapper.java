package org.pokemons.updater.mapper;

import org.pokemons.client.pokemonclient.contract.dictionaries.ability.AbilityDto;
import org.pokemons.data.model.PokemonFromAbility;
import org.springframework.stereotype.Component;

@Component
public class PokemonFromAbilityMapper implements IMap<AbilityDto.PokemonFromAbilityDto, PokemonFromAbility> {
    @Override
    public PokemonFromAbility toEntity(AbilityDto.PokemonFromAbilityDto pokemonFromAbilityDto) {
        PokemonFromAbility pokemon = new PokemonFromAbility();
        pokemon.setHidden(pokemonFromAbilityDto.isHidden());
        return pokemon;
    }
}
