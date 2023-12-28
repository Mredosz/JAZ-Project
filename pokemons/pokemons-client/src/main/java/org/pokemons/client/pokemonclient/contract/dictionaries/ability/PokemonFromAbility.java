package org.pokemons.client.pokemonclient.contract.dictionaries.ability;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.pokemons.client.pokemonclient.contract.PokemonSummaryDto;

@Getter
@Setter
public class PokemonFromAbility{
    @JsonProperty("is_hidden")
    boolean isHidden;
    @JsonProperty("pokemon")
    PokemonSummaryDto pokemon;
}