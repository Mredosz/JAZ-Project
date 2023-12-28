package org.pokemons.client.pokemonclient.contract.dictionaries.ability;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.pokemons.client.pokemonclient.contract.pokemon.PokemonSummaryDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.generation.GenerationSummaryDto;

import java.util.List;

@Getter
@Setter
public class AbilityDto extends AbilitySummaryDto {
    @JsonProperty("id")
    int sourceId;
    @JsonProperty("generation")
    GenerationSummaryDto generation;
    @JsonProperty("pokemon")
    List<PokemonFromAbilityDto> pokemon;

    @Getter
    @Setter
    public static class PokemonFromAbilityDto {
        @JsonProperty("is_hidden")
        boolean isHidden;
        @JsonProperty("pokemon")
        PokemonSummaryDto pokemon;
    }
}
