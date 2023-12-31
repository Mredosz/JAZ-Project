package org.pokemons.data.repositories;

import org.pokemons.data.model.TypeFromPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeFromPokemonRepository extends JpaRepository<TypeFromPokemon, Integer> {
    Optional<TypeFromPokemon> findFirstByTypeNameAndSlot(String typeName, int slot);
}
