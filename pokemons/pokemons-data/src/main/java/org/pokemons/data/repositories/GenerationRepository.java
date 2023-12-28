package org.pokemons.data.repositories;

import org.pokemons.data.model.Generation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenerationRepository extends JpaRepository<Generation, Integer> {
}
