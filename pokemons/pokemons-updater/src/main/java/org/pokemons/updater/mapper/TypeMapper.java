package org.pokemons.updater.mapper;

import org.pokemons.client.pokemonclient.contract.dictionaries.type.TypeDto;
import org.pokemons.data.model.Type;
import org.springframework.stereotype.Component;

@Component
public class TypeMapper implements IMap<TypeDto, Type>{
    @Override
    public Type toEntity(TypeDto typeDto) {
        Type type = new Type();
        type.setName(typeDto.getName());
        type.setSourceId(typeDto.getSourceId());
        return type;
    }
}
