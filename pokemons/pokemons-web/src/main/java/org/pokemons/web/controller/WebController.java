package org.pokemons.web.controller;

import lombok.RequiredArgsConstructor;
import org.pokemons.web.service.CacheService;
import org.pokemons.web.service.IPokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/pokemon")
@RequiredArgsConstructor
public class WebController {
    private final IPokemonService service;
    private final CacheService cacheService;

    @GetMapping("/index")
    public String getWelcomeView() {
        return "index";
    }

    @GetMapping("/all")
    public String getAllPokemons(Model model) {
        model.addAttribute("allPokemons", service.getAllPokemons());
        return "allPokemons";
    }

    @GetMapping("/{id}")
    public String getPokemonById(Model model, @PathVariable("id") int id) {
        model.addAttribute("pokemon", service.getPokemon(id));
        return "pokemon";
    }

    @GetMapping("/clearCache")
    public ResponseEntity<Void> clearCache(){
        cacheService.clearCache();
        return ResponseEntity.ok().build();
    }
}
