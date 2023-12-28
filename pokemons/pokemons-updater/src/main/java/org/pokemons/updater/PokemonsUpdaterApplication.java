package org.pokemons.updater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.pokemons")
public class PokemonsUpdaterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonsUpdaterApplication.class, args);
    }

}
