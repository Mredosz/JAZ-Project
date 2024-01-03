package org.pokemons.web.contract;

import lombok.Getter;
import lombok.Setter;
import org.pokemons.data.model.AbilityFromPokemon;
import org.pokemons.data.model.Generation;
import org.pokemons.data.model.StatsFromPokemon;
import org.pokemons.data.model.TypeFromPokemon;

import java.util.List;

@Getter
@Setter
public class PokemonDto extends PokemonSummaryDto{
    private int weight;
    private int height;
    private Generation generation;
    private List<AbilityFromPokemon> abilities;
    private List<TypeFromPokemon> types;
    private List<StatsFromPokemon> stats;
}
