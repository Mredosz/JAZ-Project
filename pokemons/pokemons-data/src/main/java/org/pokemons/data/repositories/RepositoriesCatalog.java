package org.pokemons.data.repositories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Getter
@RequiredArgsConstructor
@Repository
public class RepositoriesCatalog implements IRepositoriesCatalog {
    private final AbilityRepository ability;
    private final DamageRelationsRepository damageRelations;
    private final GenerationRepository generation;
    private final PokemonFromAbilityRepository pokemonFromAbility;
    private final PokemonFromTypeRepository pokemonFromType;
    private final TypeRepository type;
}
