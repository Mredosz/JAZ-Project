package org.pokemons.data.repositories;

import org.pokemons.data.model.Generation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenerationRepository extends JpaRepository<Generation, Integer> {
    Optional<Generation> findFirstByName(String name);
}
