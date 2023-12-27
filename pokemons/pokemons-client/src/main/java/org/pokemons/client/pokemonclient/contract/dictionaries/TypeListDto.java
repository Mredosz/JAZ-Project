package org.pokemons.client.pokemonclient.contract.dictionaries;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TypeListDto {
    @JsonProperty("results")
    private List<TypeSummaryDto> type;

    public List<TypeSummaryDto> getType() {
        return type;
    }

    public void setType(List<TypeSummaryDto> type) {
        this.type = type;
    }
}
