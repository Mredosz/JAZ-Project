package org.pokemons.web.service;

import lombok.RequiredArgsConstructor;
import org.pokemons.data.repositories.IRepositoriesCatalog;
import org.pokemons.web.contract.PokemonDto;
import org.pokemons.web.contract.PokemonSummaryDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonService implements IPokemonService {
    private final IRepositoriesCatalog dbCatalog;

    @Override
    @Cacheable(cacheNames = "pokemons")
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
    @Cacheable(cacheNames = "pokemon", key = "#id")
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
}
