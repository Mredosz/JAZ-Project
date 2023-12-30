package org.pokemons.updater.mapper;

import org.pokemons.client.pokemonclient.contract.pokemon.PokemonDto;
import org.pokemons.data.model.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper implements IMap<PokemonDto.ImageSummaryDto, Image> {
    @Override
    public Image toEntity(PokemonDto.ImageSummaryDto imageSummaryDto) {
        Image image = new Image();
        image.setUrl(imageSummaryDto.getUrl());
        return image;
    }
}
