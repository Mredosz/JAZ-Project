package org.pokemons.client.pokemonclient.contract.dictionaries.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StatsListDto {
    @JsonProperty("results")
    private List<StatsSummaryDto> stats;
}
