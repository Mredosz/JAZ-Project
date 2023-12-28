package org.pokemons.updater;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private PokemonUpdater pokemonUpdater;

    public Controller(PokemonUpdater pokemonUpdater) {
        this.pokemonUpdater = pokemonUpdater;
    }

    @GetMapping("update")
    public void update(){
        pokemonUpdater.update();
    }
}
