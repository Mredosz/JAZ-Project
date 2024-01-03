package org.pokemons.web.service;

import lombok.RequiredArgsConstructor;
import org.pokemons.data.model.Pokemon;
import org.pokemons.data.repositories.IRepositoriesCatalog;
import org.pokemons.web.contract.PokemonDto;
import org.pokemons.web.contract.PokemonSummaryDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonService implements IPokemonService {
    private final IRepositoriesCatalog dbCatalog;
    @Override
    public List<PokemonSummaryDto> getAllPokemons() {
        List<PokemonSummaryDto> pokemons = new ArrayList<>();
        for (var pokemonFromDb : dbCatalog.getPokemon().findAll()){
            PokemonSummaryDto pokemon = new PokemonSummaryDto();
            pokemon.setId(pokemonFromDb.getSourceId());
            pokemon.setImage(pokemonFromDb.getImage());
            pokemon.setName(pokemonFromDb.getName());
            pokemons.add(pokemon);
        }
        return pokemons;
    }

    @Override
    public PokemonDto getPokemon(int id) {
        PokemonDto pokemonDto = new PokemonDto();
        var pokemonFromDb = dbCatalog.getPokemon().findFirstBySourceId(id).orElse(null);
            pokemonDto.setAbilities(pokemonFromDb.getAbilities());
            pokemonDto.setStats(pokemonFromDb.getStats());
            pokemonDto.setGeneration(pokemonFromDb.getGeneration());
            pokemonDto.setWeight(pokemonFromDb.getWeight());
            pokemonDto.setTypes(pokemonFromDb.getTypes());
            pokemonDto.setHeight(pokemonFromDb.getHeight());
            pokemonDto.setId(pokemonFromDb.getSourceId());
            pokemonDto.setName(pokemonFromDb.getName());
            pokemonDto.setImage(pokemonFromDb.getImage());
            return pokemonDto;
    }

    @Override
    public void deletePokemon(int id) {
        var pokemonFromDb = dbCatalog.getPokemon().findFirstBySourceId(id).orElse(null);
        if (pokemonFromDb != null) {
            pokemonFromDb.getStats().forEach(s -> dbCatalog.getStatsFromPokemon().delete(s));
            pokemonFromDb.getAbilities().forEach(s -> dbCatalog.getAbilityFromPokemon().delete(s));
            pokemonFromDb.getTypes().forEach(s -> dbCatalog.getTypeFromPokemon().delete(s));
            dbCatalog.getPokemon().delete(pokemonFromDb);
        }
    }

    @Override
    public Pokemon updatePokemon(int id, PokemonDto dto) {
        var pokemonFromDb = dbCatalog.getPokemon().findFirstBySourceId(id).orElse(null);
        pokemonFromDb.setGeneration(dto.getGeneration());
        pokemonFromDb.setName(dto.getName());
        pokemonFromDb.setWeight(dto.getWeight());
        pokemonFromDb.setHeight(dto.getHeight());
        pokemonFromDb.setImage(dto.getImage());
        pokemonFromDb.setTypes(dto.getTypes());
        pokemonFromDb.setStats(dto.getStats());
        pokemonFromDb.setAbilities(dto.getAbilities());
        dbCatalog.getPokemon().save(pokemonFromDb);
        return pokemonFromDb;
    }

    @Override
    public void addPokemon(PokemonDto dto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setImage(dto.getImage());
        pokemon.setHeight(dto.getHeight());
        pokemon.setName(dto.getName());
        pokemon.setAbilities(dto.getAbilities());
        pokemon.setStats(dto.getStats());
        pokemon.setTypes(dto.getTypes());
        pokemon.setGeneration(dto.getGeneration());
        pokemon.setWeight(dto.getWeight());
        dbCatalog.getPokemon().save(pokemon);
    }

}
