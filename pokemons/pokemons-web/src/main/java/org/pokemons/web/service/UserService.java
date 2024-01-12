package org.pokemons.web.service;

import lombok.RequiredArgsConstructor;
import org.pokemons.data.model.User;
import org.pokemons.data.repositories.IRepositoriesCatalog;
import org.pokemons.web.contract.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final IRepositoriesCatalog dbCatalog;
    private final PasswordEncoder passwordEncoder;

    public void addUser(UserDto userDto) {
        User user = new User();
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setUsername(userDto.getUsername());
        dbCatalog.getUser().save(user);
    }

}
