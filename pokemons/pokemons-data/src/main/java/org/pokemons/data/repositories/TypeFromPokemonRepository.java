package org.pokemons.data.repositories;

import org.pokemons.data.model.TypeFromPokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeFromPokemonRepository extends JpaRepository<TypeFromPokemon, Integer> {
}
