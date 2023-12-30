package org.pokemons.client.pokemonclient.contract.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.pokemons.client.pokemonclient.contract.dictionaries.ability.AbilitySummaryDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.stats.StatsSummaryDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.type.TypeSummaryDto;

import java.util.List;

@Getter
@Setter
public class PokemonDto extends PokemonSummaryDto {
    @JsonProperty("id")
    private int sourceId;
    @JsonProperty("height")
    private int height;
    @JsonProperty("weight")
    private int weight;
    @JsonProperty("sprites")
    private ImageSummaryDto image;
    @JsonProperty("abilities")
    private List<AbilityFromPokemonDto> abilities;
    @JsonProperty("types")
    private List<TypeFromPokemonDto> types;
    @JsonProperty("stats")
    private List<StatsFromPokemonDto> stats;

    @Getter
    @Setter
    public static class AbilityFromPokemonDto {
        @JsonProperty("slot")
        private int slot;
        @JsonProperty("ability")
        private AbilitySummaryDto ability;
    }
    @Getter
    @Setter
    public static class ImageSummaryDto {
        @JsonProperty("front_default")
        private String url;
    }
    @Getter
    @Setter
    public static class StatsFromPokemonDto {
        @JsonProperty("base_stat")
        private int baseStat;
        @JsonProperty("effort")
        private int effort;
        @JsonProperty("stat")
        private StatsSummaryDto stats;
    }
    @Getter
    @Setter
    public static class TypeFromPokemonDto {
        @JsonProperty("slot")
        private int slot;
        @JsonProperty("type")
        private TypeSummaryDto type;
    }

}
