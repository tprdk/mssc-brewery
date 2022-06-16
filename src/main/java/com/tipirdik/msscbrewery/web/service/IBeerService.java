package com.tipirdik.msscbrewery.web.service;

import com.tipirdik.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface IBeerService {
    BeerDto getBeerByID(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeerById(UUID beerId, BeerDto beerDto);
}
