package org.pokemons.updater;


import lombok.RequiredArgsConstructor;
import org.pokemons.client.pokemonclient.IPokemonClient;
import org.pokemons.client.pokemonclient.contract.dictionaries.IPokemonDictionariesClient;
import org.pokemons.client.pokemonclient.contract.dictionaries.ability.AbilityDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.generation.GenerationDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.stats.StatsSummaryDto;
import org.pokemons.client.pokemonclient.contract.dictionaries.type.TypeDto;
import org.pokemons.client.pokemonclient.contract.pokemon.PokemonDto;
import org.pokemons.data.model.Pokemon;
import org.pokemons.data.repositories.IRepositoriesCatalog;
import org.pokemons.updater.mapper.IMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonUpdater implements IPokemonUpdater {
    private final IMapper mapper;
    private final IRepositoriesCatalog dbCatalog;
    private final IPokemonDictionariesClient dictionariesClient;
    private final IPokemonClient client;

    @Override
    public void update(int quantity) {
        updateDictionaries();
        updatePokemon(quantity);
        saveGenerationToPokemon();
    }

    private List<TypeDto> getTypeDtoList() {
        List<TypeDto> typeDtoList = new ArrayList<>();
        dictionariesClient.getTypes().forEach(type ->
                typeDtoList
                        .add(dictionariesClient.getType(type.getName())));
        return typeDtoList;
    }

    private List<AbilityDto> getAbilityDtoList() {
        List<AbilityDto> abilityDtoList = new ArrayList<>();
        dictionariesClient.getAbilities()
                .forEach(ability ->
                        abilityDtoList
                                .add(dictionariesClient.getAbility(ability.getName())));
        return abilityDtoList;
    }

    private List<GenerationDto> getGenerationDtoList() {
        List<GenerationDto> generationDtoList = new ArrayList<>();
        dictionariesClient.getGenerations()
                .forEach(generation ->
                        generationDtoList
                                .add(dictionariesClient.getGeneration(generation.getName())));
        return generationDtoList;
    }

    private List<PokemonDto> getPokemonDtoList(int quantity) {
        List<PokemonDto> pokemonDtoList = new ArrayList<>();
        client.getPokemons(quantity)
                .forEach(pokemon ->
                        pokemonDtoList
                                .add(client.getPokemon(pokemon.getName())));
        return pokemonDtoList;
    }

    private void saveAbility(AbilityDto abilityDto) {
        var generationFromDb = dbCatalog.getGeneration().findAll();
        var ability = mapper.getAbility().toEntity(abilityDto);
        var abilityFromDb = dbCatalog.getAbility()
                .findFirstByName(ability.getName())
                .orElse(null);

        ability.setGeneration(
                generationFromDb
                        .stream()
                        .filter(g -> g.getName().equals(abilityDto.getGeneration().getName()))
                        .findFirst().orElse(null));
        if (abilityFromDb == null) {
            dbCatalog.getAbility().save(ability);
        }
    }

    private void saveGeneration(GenerationDto generationDto) {
        var generation = mapper.getGeneration().toEntity(generationDto);
        var generationFromDb = dbCatalog.getGeneration()
                .findFirstByName(generation.getName())
                .orElse(null);
        if (generationFromDb == null) {
            dbCatalog.getGeneration().save(generation);
        }
    }

    private void saveGenerationToPokemon() {
        for (var pokemonFromDb : dbCatalog.getPokemon().findAll()) {
            for (var generationDto : getGenerationDtoList()) {
                for (var pokemonFromGeneration : generationDto.getPokemons()) {
                    for (var generationFromDb : dbCatalog.getGeneration().findAll()) {
                        if (pokemonFromDb.getName().equals(pokemonFromGeneration.getName())) {
                            if (generationDto.getName().equals(generationFromDb.getName())) {
                                pokemonFromDb.setGeneration(generationFromDb);
                                dbCatalog.getPokemon().save(pokemonFromDb);
                            }
                        }
                    }
                }
            }
        }
    }

    private void saveType(TypeDto typeDto) {
        var type = mapper.getType().toEntity(typeDto);
        var typeFromDb = dbCatalog.getType()
                .findFirstByName(type.getName())
                .orElse(null);
        if (typeFromDb == null) {
            dbCatalog.getType().save(type);
        }
    }

    private void saveStats(StatsSummaryDto statsSummaryDto) {
        var stats = mapper.getStats().toEntity(statsSummaryDto);
        var statsFromDb = dbCatalog.getStats()
                .findFirstByName(stats.getName())
                .orElse(null);
        if (statsFromDb == null) {
            dbCatalog.getStats().save(stats);
        }
    }

    private void updateDictionaries() {
        getGenerationDtoList().forEach(this::saveGeneration);
        getAbilityDtoList().forEach(this::saveAbility);
        getTypeDtoList().forEach(this::saveType);
        client.getStats().forEach(this::saveStats);
    }

    private void savePokemon(PokemonDto pokemonDto) {
        var pokemon = mapper.getPokemon().toEntity(pokemonDto);
        var pokemonFromDb = dbCatalog.getPokemon()
                .findFirstByName(pokemon.getName())
                .orElse(null);
        if (pokemonFromDb == null) {
            setRelationsToPokemon(pokemonDto, pokemon);
        }
    }

    private void setRelationsToPokemon(PokemonDto pokemonDto, Pokemon pokemon) {
//        for (var typeFromDb : dbCatalog.getType().findAll()){
//            for (var typeFromPokemonDto : pokemonDto.getTypes()){
//                if (typeFromDb.getName().equals(typeFromPokemonDto.getType().getName())){
//                    pokemon.getTypes().add(typeFromDb);
//                }
//            }
//        }


        saveImage(pokemonDto, pokemon);
        dbCatalog.getPokemon().save(pokemon);
    }

    private void saveImage(PokemonDto pokemonDto, Pokemon pokemon) {
        var image = mapper.getImage().toEntity(pokemonDto.getImage());
        dbCatalog.getImage().save(image);
        pokemon.setImage(image);
//        image.setPokemon(pokemon);
    }

    private void updatePokemon(int quantity) {
        getPokemonDtoList(quantity).forEach(this::savePokemon);
    }
}
