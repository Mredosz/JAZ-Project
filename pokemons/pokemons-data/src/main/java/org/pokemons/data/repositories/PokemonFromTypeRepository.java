package org.pokemons.data.repositories;

import org.pokemons.data.model.PokemonFromType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonFromTypeRepository extends JpaRepository<PokemonFromType, Integer> {
}
