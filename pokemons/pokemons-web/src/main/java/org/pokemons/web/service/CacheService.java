package org.pokemons.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheService {

    @CacheEvict(value = "pokemons", allEntries = true)
    public void clearCache(){
        log.info("Cache 'pokemons' has been cleared");
    }
}
