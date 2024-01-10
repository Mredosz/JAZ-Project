package org.pokemons.updater.controler;

import org.pokemons.updater.service.PokemonUpdater;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class Controller {
    private PokemonUpdater pokemonUpdater;

    public Controller(PokemonUpdater pokemonUpdater) {
        this.pokemonUpdater = pokemonUpdater;
    }

    @GetMapping("update")
    public ResponseEntity update(@RequestParam int quantity){
       new Thread(()-> pokemonUpdater.update(quantity)).start();
       return ResponseEntity.ok("Start at " + LocalDateTime.now());
    }
}
