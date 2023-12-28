package org.pokemons.client.pokemonclient.contract.dictionaries.generation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GenerationListDto {
    @JsonProperty("results")
    private List<GenerationSummaryDto> generations;

}
