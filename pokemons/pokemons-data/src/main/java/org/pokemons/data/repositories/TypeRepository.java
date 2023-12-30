package org.pokemons.data.repositories;

import org.pokemons.data.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Integer> {
    Optional<Type> findFirstByName(String name);
}
