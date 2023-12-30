package org.pokemons.updater.mapper;

public interface IMapper {
    AbilityFromPokemonMapper getAbilityFromPokemon();
    AbilityMapper getAbility();
    DamageRelationsMapper getDamageRelations();
    GenerationMapper getGeneration();
    PokemonFromAbilityMapper getPokemonFromAbility();
    PokemonFromTypeMapper getPokemonFromType();
    PokemonMapper getPokemon();
    ImageMapper getImage();
    StatsFromPokemonMapper getStatsFromPokemon();
    StatsMapper getStats();
    TypeFromPokemonMapper getTypeFromPokemon();
    TypeMapper getType();
}
