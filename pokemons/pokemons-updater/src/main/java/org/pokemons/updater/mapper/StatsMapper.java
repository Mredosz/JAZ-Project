package org.pokemons.updater.mapper;

import org.pokemons.client.pokemonclient.contract.dictionaries.stats.StatsSummaryDto;
import org.pokemons.data.model.Stats;
import org.springframework.stereotype.Component;

@Component
public class StatsMapper implements IMap<StatsSummaryDto, Stats> {
    @Override
    public Stats toEntity(StatsSummaryDto statsSummaryDto) {
        Stats stats = new Stats();
        stats.setName(statsSummaryDto.getName());
        return stats;
    }
}
