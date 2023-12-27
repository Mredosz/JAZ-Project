package org.pokemons.client.pokemonclient.contract.dictionaries;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.pokemons.client.pokemonclient.contract.PokemonSummaryDto;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
public class TypeDto {
    @JsonProperty("id")
    private int sourceId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("damage_relations")
    private Object damageRelations;
    @JsonProperty("double_damage_from")
    private TypeSummaryDto doubleDamageFrom;
    @JsonProperty("double_damage_to")
    private List<TypeSummaryDto> doubleDamageTo;
    @JsonProperty("half_damage_from")
    private List<TypeSummaryDto> halfDamageFrom;
    @JsonProperty("half_damage_to")
    private List<TypeSummaryDto> halfDamageTo;
    @JsonProperty("no_damage_from")
    private List<TypeSummaryDto> noDamageFrom;
    @JsonProperty("no_damage_to")
    private List<TypeSummaryDto> noDamageTo;
    @JsonProperty("pokemon")
    private Object pokemons;

}
