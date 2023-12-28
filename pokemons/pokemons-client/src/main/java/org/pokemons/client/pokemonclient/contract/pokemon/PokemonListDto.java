package org.pokemons.client.pokemonclient.contract.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PokemonListDto {
    @JsonProperty("results")
    List<PokemonSummaryDto> pokemons;
}
