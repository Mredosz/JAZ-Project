package org.pokemons.data.repositories;

import org.pokemons.data.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
    Optional<Pokemon> findFirstByName(String name);
    Optional<Pokemon> findFirstBySourceId(int id);
}
