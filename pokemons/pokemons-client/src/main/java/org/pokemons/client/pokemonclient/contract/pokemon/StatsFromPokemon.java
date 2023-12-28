package org.pokemons.client.pokemonclient.contract.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatsFromPokemon {
    @JsonProperty("base_stat")
    private int baseStat;
    @JsonProperty("effort")
    private int effort;
    @JsonProperty("stat")
    private StatsSummaryDto stats;
}
