package org.pokemons.client.pokemonclient.contract.dictionaries;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GenerationListDto {
    @JsonProperty("results")
    private List<GenerationSummaryDto> generations;

    public List<GenerationSummaryDto> getGenerations() {
        return generations;
    }

    public void setGenerations(List<GenerationSummaryDto> generations) {
        this.generations = generations;
    }
}
