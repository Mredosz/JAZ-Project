package org.pokemons.data.repositories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Getter
@RequiredArgsConstructor
@Repository
public class RepositoriesCatalog implements IRepositoriesCatalog {
    private final AbilityFromPokemonRepository abilityFromPokemon;
    private final AbilityRepository ability;
    private final DamageRelationsRepository damageRelations;
    private final GenerationRepository generation;
    private final PokemonFromAbilityRepository pokemonFromAbility;
    private final PokemonFromTypeRepository pokemonFromType;
    private final PokemonRepository pokemon;
    private final ImageRepository image;
    private final StatsFromPokemonRepository statsFromPokemon;
    private final StatsRepository stats;
    private final TypeFromPokemonRepository typeFromPokemon;
    private final TypeRepository type;
}
