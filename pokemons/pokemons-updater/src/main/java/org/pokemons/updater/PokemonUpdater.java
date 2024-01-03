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
import java.util.stream.Collectors;

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
        saveImageFromDb();
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

    private List<PokemonDto> getPokemonDtoList(int quantity, int nextId) {
        List<PokemonDto> pokemonDtoList = new ArrayList<>();
        client.getPokemons(quantity, nextId)
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
        for (var generationDto : getGenerationDtoList()) {
            for (var pokemonFromGeneration : generationDto.getPokemons()) {
                var pokemonFromDb = dbCatalog.getPokemon().findFirstByName(pokemonFromGeneration.getName()).orElse(null);
                for (var generationFromDb : dbCatalog.getGeneration().findAll()) {
                    if (generationDto.getName().equals(generationFromDb.getName()) && pokemonFromDb != null) {
                        pokemonFromDb.setGeneration(generationFromDb);
                        dbCatalog.getPokemon().save(pokemonFromDb);
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
        if (dbCatalog.getGeneration().findAll().size() < 9) getGenerationDtoList().forEach(this::saveGeneration);
        if (dbCatalog.getAbility().findAll().size() < 367) getAbilityDtoList().forEach(this::saveAbility);
        if (dbCatalog.getType().findAll().size() < 20) getTypeDtoList().forEach(this::saveType);
        if (dbCatalog.getStats().findAll().size() < 8) client.getStats().forEach(this::saveStats);
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
        pokemonDto.getTypes().forEach(this::saveTypeFromPokemon);
        pokemonDto.getStats().forEach(this::saveStatsFromPokemon);
        pokemonDto.getAbilities().forEach(this::saveAbilityFromPokemon);
        setAbilityRelation(pokemonDto, pokemon);
        setTypeRelation(pokemonDto, pokemon);
        setStatsRelation(pokemonDto, pokemon);
        dbCatalog.getPokemon().save(pokemon);
        saveImage(pokemonDto, pokemon);
    }

    private void setAbilityRelation(PokemonDto pokemonDto, Pokemon pokemon) {
        for (var abilityFromDb : dbCatalog.getAbilityFromPokemon().findAll()) {
            for (var abilityFromPokemon : pokemonDto.getAbilities()) {
                if (abilityFromDb.getAbility().getName().equals(abilityFromPokemon.getAbility().getName()) && abilityFromDb.getSlot() == abilityFromPokemon.getSlot()) {
                    pokemon.getAbilities().add(abilityFromDb);
                    abilityFromDb.getPokemons().add(pokemon);
                }
            }
        }
    }

    private void setTypeRelation(PokemonDto pokemonDto, Pokemon pokemon) {
        for (var typeFromDb : dbCatalog.getTypeFromPokemon().findAll()) {
            for (var typeFromPokemon : pokemonDto.getTypes()) {
                if (typeFromDb.getType().getName().equals(typeFromPokemon.getType().getName()) && typeFromDb.getSlot() == typeFromPokemon.getSlot()) {
                    pokemon.getTypes().add(typeFromDb);
                    typeFromDb.getPokemons().add(pokemon);
                }
            }
        }
    }

    private void setStatsRelation(PokemonDto pokemonDto, Pokemon pokemon) {
        for (var statsFromDb : dbCatalog.getStatsFromPokemon().findAll()) {
            for (var statsFromPokemon : pokemonDto.getStats()) {
                if (statsFromDb.getStats().getName().equals(statsFromPokemon.getStats().getName()) && statsFromDb.getBaseStat() == statsFromPokemon.getBaseStat()) {
                    pokemon.getStats().add(statsFromDb);
                    statsFromDb.getPokemons().add(pokemon);
                }
            }
        }
    }

    private void saveImage(PokemonDto pokemonDto, Pokemon pokemon) {
        var image = mapper.getImage().toEntity(pokemonDto.getImage());
        var imageFromDb = dbCatalog.getImage()
                .findFirstByUrl(image.getUrl())
                .orElse(null);
        if (imageFromDb == null) {
            dbCatalog.getImage().save(image);
            pokemon.setImage(image);
        }else {
            pokemon.setImage(imageFromDb);
        }
    }

    private void updatePokemon(int quantity) {
        var theLastId = dbCatalog.getPokemon().findAll()
                .stream()
                .collect(Collectors.summarizingInt(Pokemon::getSourceId))
                .getMax();
        if (theLastId <= 0) {
            theLastId = 0;
        }
        getPokemonDtoList(quantity, theLastId).forEach(this::savePokemon);
    }

    private void saveTypeFromPokemon(PokemonDto.TypeFromPokemonDto typeFromPokemonDto) {
        var type = mapper.getTypeFromPokemon().toEntity(typeFromPokemonDto);
        var typeFromDb = dbCatalog.getType()
                .findFirstByName(typeFromPokemonDto.getType().getName())
                .orElse(null);
        if (typeFromDb != null) type.setType(typeFromDb);
        var typeFromPokemonFromDb = dbCatalog.getTypeFromPokemon()
                .findFirstByTypeNameAndSlot(type.getType().getName(), type.getSlot())
                .orElse(null);
        if (typeFromPokemonFromDb == null) {
            dbCatalog.getTypeFromPokemon().save(type);
        }
    }

    private void saveStatsFromPokemon(PokemonDto.StatsFromPokemonDto statsFromPokemonDto) {
        var stat = mapper.getStatsFromPokemon().toEntity(statsFromPokemonDto);
        var statFromDb = dbCatalog.getStats()
                .findFirstByName(statsFromPokemonDto.getStats().getName())
                .orElse(null);
        if (statFromDb != null) stat.setStats(statFromDb);
        var statFromPokemonFromDb = dbCatalog.getStatsFromPokemon()
                .findFirstByStatsNameAndBaseStat(stat.getStats().getName(), stat.getBaseStat())
                .orElse(null);
        if (statFromPokemonFromDb == null) {
            dbCatalog.getStatsFromPokemon().save(stat);
        }
    }

    private void saveAbilityFromPokemon(PokemonDto.AbilityFromPokemonDto abilityFromPokemonDto) {
        var ability = mapper.getAbilityFromPokemon().toEntity(abilityFromPokemonDto);
        var abilityFromDb = dbCatalog.getAbility()
                .findFirstByName(abilityFromPokemonDto.getAbility().getName())
                .orElse(null);
        if (abilityFromDb != null) ability.setAbility(abilityFromDb);
        var abilityFromPokemonFromDb = dbCatalog.getAbilityFromPokemon()
                .findFirstByAbilityNameAndSlot(ability.getAbility().getName(), ability.getSlot())
                .orElse(null);
        if (abilityFromPokemonFromDb == null) {
            dbCatalog.getAbilityFromPokemon().save(ability);
        }
    }

    private void saveImageFromDb(){
        var pokemonFromDb = dbCatalog.getPokemon().findAll();
        for (var pokemon : pokemonFromDb){
            if (pokemon.getImage() == null){
                pokemon.setImage(dbCatalog.getImage().findById(pokemon.getSourceId()).orElse(null));
                dbCatalog.getPokemon().save(pokemon);
            }
        }
    }
}
