package org.pokemons.client.pokemonclient.contract.dictionaries.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.pokemons.client.pokemonclient.contract.pokemon.PokemonSummaryDto;

import java.util.List;

@Setter
@Getter
public class TypeDto extends TypeSummaryDto {
    @JsonProperty("id")
    private int sourceId;
    @JsonProperty("pokemon")
    private List<PokemonFromTypeDto> pokemon;

    @Getter
    @Setter
    public static class PokemonFromTypeDto {
        @JsonProperty("pokemon")
        PokemonSummaryDto pokemonSummaryDto;
    }
}