package org.pokemons.client.pokemonclient.contract.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.pokemons.client.pokemonclient.contract.dictionaries.ability.AbilitySummaryDto;

@Getter
@Setter
public class AbilityFromPokemon {
    @JsonProperty("slot")
    private int slot;
    @JsonProperty("ability")
    private AbilitySummaryDto ability;
}
