package org.pokemons.data.repositories;

public interface IRepositoriesCatalog {
    AbilityRepository getAbility();
    DamageRelationsRepository getDamageRelations();
    GenerationRepository getGeneration();
    PokemonFromAbilityRepository getPokemonFromAbility();
    PokemonFromTypeRepository getPokemonFromType();
    TypeRepository getType();
}
