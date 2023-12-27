package org.pokemons.client.pokemonclient.contract.dictionaries;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AbilityListDto {
    @JsonProperty("results")
    private List<AbilitySummaryDto> abilities;

    public List<AbilitySummaryDto> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilitySummaryDto> abilities) {
        this.abilities = abilities;
    }
}
