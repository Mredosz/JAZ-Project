package org.pokemons.client.pokemonclient.contract.dictionaries.generation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.pokemons.client.pokemonclient.contract.PokemonSummaryDto;

import java.util.List;

@Getter
@Setter
public class GenerationDto extends GenerationSummaryDto{
    @JsonProperty("id")
    private int sourceId;
    @JsonProperty("pokemon_species")
    private List<PokemonSummaryDto> pokemons;
}
