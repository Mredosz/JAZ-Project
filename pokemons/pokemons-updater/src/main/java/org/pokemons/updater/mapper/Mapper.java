package org.pokemons.updater.mapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class Mapper implements IMapper {
    private final AbilityFromPokemonMapper abilityFromPokemon;
    private final AbilityMapper ability;
    private final DamageRelationsMapper damageRelations;
    private final GenerationMapper generation;
    private final PokemonFromAbilityMapper pokemonFromAbility;
    private final PokemonFromTypeMapper pokemonFromType;
    private final PokemonMapper pokemon;
    private final ImageMapper image;
    private final StatsFromPokemonMapper statsFromPokemon;
    private final StatsMapper stats;
    private final TypeFromPokemonMapper typeFromPokemon;
    private final TypeMapper type;
}
