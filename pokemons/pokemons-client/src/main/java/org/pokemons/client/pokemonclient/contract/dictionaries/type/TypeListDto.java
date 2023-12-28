package org.pokemons.client.pokemonclient.contract.dictionaries.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class TypeListDto {
    @JsonProperty("results")
    private List<TypeSummaryDto> type;

}
