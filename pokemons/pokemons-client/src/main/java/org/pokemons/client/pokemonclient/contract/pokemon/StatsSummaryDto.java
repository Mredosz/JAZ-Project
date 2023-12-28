package org.pokemons.client.pokemonclient.contract.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatsSummaryDto {
    @JsonProperty("name")
    private String name;
}
