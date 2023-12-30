package org.pokemons.updater.mapper;

import org.pokemons.client.pokemonclient.contract.dictionaries.ability.AbilityDto;
import org.pokemons.data.model.Ability;
import org.springframework.stereotype.Component;

@Component
public class AbilityMapper implements IMap<AbilityDto, Ability> {
    @Override
    public Ability toEntity(AbilityDto abilityDto) {
        Ability ability = new Ability();
        ability.setName(abilityDto.getName());
        ability.setSourceId(abilityDto.getSourceId());
        return ability;
    }
}
