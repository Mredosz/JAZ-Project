package org.pokemons.client.pokemonclient.contract.dictionaries.generation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenerationSummaryDto {
    @JsonProperty("name")
    private String name;
}
