package org.pokemons.client.pokemonclient.contract.dictionaries.ability;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AbilitySummaryDto {
    @JsonProperty("name")
    private String name;
}
