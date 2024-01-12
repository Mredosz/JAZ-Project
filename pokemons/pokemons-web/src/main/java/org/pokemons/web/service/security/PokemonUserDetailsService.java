package org.pokemons.web.service.security;

import lombok.RequiredArgsConstructor;
import org.pokemons.data.model.User;
import org.pokemons.data.repositories.IRepositoriesCatalog;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class PokemonUserDetailsService implements UserDetailsService {
    private final IRepositoriesCatalog dbCatalog;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dbCatalog.getUser().findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User doesn't exist " + username));

        return new PokemonUserDetails(user.getId(), user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
