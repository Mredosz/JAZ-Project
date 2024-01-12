package org.pokemons.web.controller;

import lombok.RequiredArgsConstructor;
import org.pokemons.data.repositories.IRepositoriesCatalog;
import org.pokemons.web.contract.UserDto;
import org.pokemons.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final IRepositoriesCatalog dbCatalog;

    @GetMapping("/registration")
    public String addUser(Model model){
        model.addAttribute("user", new UserDto("", ""));
        return "signUp";
    }
    @PostMapping("/registration")
    public String addUser(@ModelAttribute UserDto userDto, Model model){
        var userFromDb = dbCatalog.getUser().findByUsername(userDto.getUsername()).orElse(null);
        if (userFromDb != null){
            model.addAttribute("user", new UserDto("", ""));
            model.addAttribute("errorMessage", "User Already Exist.");
            return "signUp";
        }
        service.addUser(userDto);
        return "redirect:/login";
    }
}
