package org.pokemons.client.pokemonclient.contract.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PokemonSummaryDto {
    @JsonProperty("name")
    private String name;
}
