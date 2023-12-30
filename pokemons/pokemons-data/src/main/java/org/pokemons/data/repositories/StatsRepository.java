package org.pokemons.data.repositories;

import org.pokemons.data.model.Stats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatsRepository extends JpaRepository<Stats, Integer> {
    Optional<Stats> findFirstByName(String  name);
}
