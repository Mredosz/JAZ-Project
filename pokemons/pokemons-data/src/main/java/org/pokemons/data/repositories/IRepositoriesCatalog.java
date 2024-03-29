package org.pokemons.data.repositories;

public interface IRepositoriesCatalog {
    AbilityFromPokemonRepository getAbilityFromPokemon();
    AbilityRepository getAbility();
    GenerationRepository getGeneration();
    PokemonFromAbilityRepository getPokemonFromAbility();
    PokemonFromTypeRepository getPokemonFromType();
    PokemonRepository getPokemon();
    ImageRepository getImage();
    StatsFromPokemonRepository getStatsFromPokemon();
    StatsRepository getStats();
    TypeFromPokemonRepository getTypeFromPokemon();
    TypeRepository getType();
    UserRepository getUser();
}
