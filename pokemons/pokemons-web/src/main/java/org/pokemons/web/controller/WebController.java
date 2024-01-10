package org.pokemons.web.controller;

import lombok.RequiredArgsConstructor;
import org.pokemons.web.contract.PokemonDto;
import org.pokemons.web.service.CacheService;
import org.pokemons.web.service.IPokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/delete/{id}")
    public String deletePokemonById(@PathVariable("id") int id) {
        service.deletePokemon(id);
        return "redirect:/api/v1/pokemon/all";
    }

    @GetMapping("/update/{id}")
    public String updatePokemonById(Model model, @PathVariable("id") int id) {
        var pokemonFromDb = service.getPokemon(id);
        model.addAttribute("pokemon", service.updatePokemon(id, pokemonFromDb));
        return "updatePokemon";
    }

    @PostMapping("/update")
    public String updatePokemonById(@ModelAttribute PokemonDto dto) {
        service.updatePokemon(dto.getId(), dto);
        return "redirect:/api/v1/pokemon/all";
    }

    @GetMapping("/add")
    public String addPokemon(Model model){
        model.addAttribute("pokemon", new PokemonDto());
        return "addPokemon";
    }
    @PostMapping("/add")
    public String addPokemon(@ModelAttribute PokemonDto pokemonDto){
        service.addPokemon(pokemonDto);
        return "redirect:/api/v1/pokemon/all";
    }

    @GetMapping("/clearCache")
    public ResponseEntity<Void> clearCache(){
        cacheService.clearCache();
        return ResponseEntity.ok().build();
    }
}
