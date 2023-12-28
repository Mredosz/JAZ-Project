package org.pokemons.updater.mapper;

import org.pokemons.client.pokemonclient.contract.dictionaries.generation.GenerationDto;
import org.pokemons.data.model.Generation;
import org.springframework.stereotype.Component;

@Component
public class GenerationMapper implements IMap<GenerationDto, Generation>{
    @Override
    public Generation toEntity(GenerationDto generationDto) {
        Generation generation = new Generation();
        generation.setName(generationDto.getName());
        generation.setSourceId(generationDto.getSourceId());
        return generation;
    }
}
