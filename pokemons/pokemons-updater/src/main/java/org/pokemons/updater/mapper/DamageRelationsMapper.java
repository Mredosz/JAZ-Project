package org.pokemons.updater.mapper;

import org.pokemons.client.pokemonclient.contract.dictionaries.type.TypeDto;
import org.pokemons.data.model.DamageRelations;
import org.springframework.stereotype.Component;

@Component
public class DamageRelationsMapper implements IMap<TypeDto.DamageRelationsDto, DamageRelations>{
    @Override
    public DamageRelations toEntity(TypeDto.DamageRelationsDto damageRelationsDto) {
        DamageRelations damageRelations = new DamageRelations();
        return damageRelations;
    }
}
