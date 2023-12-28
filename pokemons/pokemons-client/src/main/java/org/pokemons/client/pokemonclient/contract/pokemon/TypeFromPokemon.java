package org.pokemons.client.pokemonclient.contract.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.pokemons.client.pokemonclient.contract.dictionaries.type.TypeSummaryDto;

@Getter
@Setter
public class TypeFromPokemon {
    @JsonProperty("slot")
    private int slot;
    @JsonProperty("type")
    private TypeSummaryDto type;
}
