package org.pokemons.client.pokemonclient.contract.dictionaries.ability;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AbilityListDto {
    @JsonProperty("results")
    private List<AbilitySummaryDto> abilities;

}
