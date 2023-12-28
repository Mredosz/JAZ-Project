package org.pokemons.data.repositories;

import org.pokemons.data.model.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityRepository extends JpaRepository<Ability, Integer> {
}
