package org.pokemons.updater;


import lombok.RequiredArgsConstructor;
import org.pokemons.client.pokemonclient.contract.dictionaries.IPokemonDictionariesClient;
import org.pokemons.client.pokemonclient.contract.dictionaries.generation.GenerationDto;
import org.pokemons.data.repositories.IRepositoriesCatalog;
import org.pokemons.updater.mapper.GenerationMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonUpdater {
    final GenerationMapper generationMapper;
    final IRepositoriesCatalog dbCatalog;
    final IPokemonDictionariesClient client;


    public void update(){
        List<GenerationDto> generationDtoList = new ArrayList<>();
        for (var generation : client.getGenerations()){
            generationDtoList.add(client.getGeneration(generation.getName()));
        }
        for (var generation : generationDtoList){
            var generationMapperEntity = generationMapper.toEntity(generation);
//            var generationFromDb = dbCatalog.getGeneration()
//                    .findFirstByName(generation.getName())
//                    .orElse(null);
            dbCatalog.getGeneration().save(generationMapperEntity);

        }
    }

}
