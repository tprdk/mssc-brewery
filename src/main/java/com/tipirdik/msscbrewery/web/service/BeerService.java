package com.tipirdik.msscbrewery.web.service;

import com.tipirdik.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class BeerService implements IBeerService{
    @Override
    public BeerDto getBeerByID(UUID beerId) {
        return BeerDto.builder().id(beerId)
                .beerName("Bud")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(beerDto.getId())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .upc(beerDto.getUpc())
                .build();
    }

    @Override
    public BeerDto updateBeerById(UUID beerId, BeerDto beerDto) {
        return BeerDto.builder()
                .id(beerId)
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .upc(beerDto.getUpc())
                .build();
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        // Deleted beer by id
    }
}
