package org.pokemons.client.pokemonclient.contract.dictionaries.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DamageRelations{
    @JsonProperty("double_damage_from")
    private List<TypeSummaryDto> doubleDamageFrom;
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
}