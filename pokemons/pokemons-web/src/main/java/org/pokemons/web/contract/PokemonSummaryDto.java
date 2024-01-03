package org.pokemons.web.contract;

import lombok.Getter;
import lombok.Setter;
import org.pokemons.data.model.Image;

@Getter
@Setter
public class PokemonSummaryDto {
    private int id;
    private String name;
    private Image image;
}
