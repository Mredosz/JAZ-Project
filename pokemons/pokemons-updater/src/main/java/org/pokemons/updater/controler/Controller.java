package org.pokemons.updater.controler;

import org.pokemons.updater.service.PokemonUpdater;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private PokemonUpdater pokemonUpdater;

    public Controller(PokemonUpdater pokemonUpdater) {
        this.pokemonUpdater = pokemonUpdater;
    }

    @GetMapping("update")
    public void update(@RequestParam int quantity){
        pokemonUpdater.update(quantity);
    }
}
