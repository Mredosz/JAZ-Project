package org.pokemons.client.pokemonclient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.pokemons.client.pokemonclient.contract.dictionaries.ability.AbilitySummaryDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.type.TypeSummaryDto;
import org.pokemons.client.pokemonclient.contract.pokemon.AbilityFromPokemon;
import org.pokemons.client.pokemonclient.contract.pokemon.SpritesSummaryDto;
import org.pokemons.client.pokemonclient.contract.pokemon.StatsFromPokemon;
import org.pokemons.client.pokemonclient.contract.pokemon.TypeFromPokemon;

import java.util.List;

@Getter
@Setter
public class PokemonDto extends PokemonSummaryDto{
    @JsonProperty("id")
    private int sourceId;
    @JsonProperty("height")
    private int height;
    @JsonProperty("weight")
    private int weight;
    @JsonProperty("sprites")
    private SpritesSummaryDto image;
    @JsonProperty("abilities")
    private List<AbilityFromPokemon> abilities;
    @JsonProperty("types")
    private List<TypeFromPokemon> types;
    @JsonProperty("stats")
    private List<StatsFromPokemon> stats;
}
