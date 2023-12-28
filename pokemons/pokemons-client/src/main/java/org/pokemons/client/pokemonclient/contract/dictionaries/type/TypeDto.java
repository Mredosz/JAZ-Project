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
    @JsonProperty("damage_relations")
    private DamageRelationsDto damageRelations;
    @JsonProperty("pokemon")
    private List<PokemonFromTypeDto> pokemon;

    @Getter
    @Setter
    public static class DamageRelationsDto {
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

    @Getter
    @Setter
    public static class PokemonFromTypeDto {
        @JsonProperty("pokemon")
        PokemonSummaryDto pokemonSummaryDto;
    }
}