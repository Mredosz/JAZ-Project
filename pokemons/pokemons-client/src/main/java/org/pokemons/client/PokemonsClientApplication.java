package org.pokemons.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.pokemons")
public class PokemonsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonsClientApplication.class, args);
    }

}
