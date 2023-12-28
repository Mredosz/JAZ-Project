package org.pokemons.client.pokemonclient.contract.dictionaries.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TypeSummaryDto {
    @JsonProperty("name")
    private String name;
}
