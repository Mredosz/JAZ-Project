package org.pokemons.data.repositories;

import org.pokemons.data.model.AbilityFromPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AbilityFromPokemonRepository extends JpaRepository<AbilityFromPokemon, Integer> {
    Optional<AbilityFromPokemon> findFirstByAbilityNameAndSlot(String abilityName, int slot);
}
