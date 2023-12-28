package org.pokemons.data.repositories;

import org.pokemons.data.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Integer> {
}
