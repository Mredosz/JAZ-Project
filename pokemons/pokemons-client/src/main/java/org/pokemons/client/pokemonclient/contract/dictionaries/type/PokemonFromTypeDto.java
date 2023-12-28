package org.pokemons.client.pokemonclient.contract.dictionaries.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.pokemons.client.pokemonclient.contract.PokemonSummaryDto;

@Getter
@Setter
public class PokemonFromTypeDto {
    @JsonProperty("pokemon")
    PokemonSummaryDto pokemonSummaryDto;
}