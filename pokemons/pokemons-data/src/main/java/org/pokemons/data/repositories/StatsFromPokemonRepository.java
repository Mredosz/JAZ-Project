package org.pokemons.data.repositories;

import org.pokemons.data.model.StatsFromPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsFromPokemonRepository extends JpaRepository<StatsFromPokemon, Integer> {
}
