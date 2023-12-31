package org.pokemons.data.repositories;

import org.pokemons.data.model.StatsFromPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatsFromPokemonRepository extends JpaRepository<StatsFromPokemon, Integer> {
    Optional<StatsFromPokemon> findFirstByStatsNameAndBaseStat(String statsName, int baseStat);
}
