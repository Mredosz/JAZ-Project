package org.pokemons.client.pokemonclient.contract.pokemon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpritesSummaryDto {
    @JsonProperty("front_default")
    private String image;
}
