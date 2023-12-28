package org.pokemons.updater.mapper;

public interface IMap<TDto, TEntity> {
    TEntity toEntity(TDto tDto);
}
