package org.pokemons.client.pokemonclient.contract.dictionaries.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TypeDto extends TypeSummaryDto {
    @JsonProperty("id")
    private int sourceId;
    @JsonProperty("damage_relations")
    private DamageRelations damageRelations;
    @JsonProperty("pokemon")
    private List<PokemonFromTypeDto> pokemon;
}