package com.tipirdik.msscbrewery.web.controller;

import com.tipirdik.msscbrewery.web.model.BeerDto;
import com.tipirdik.msscbrewery.web.service.IBeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    @Autowired
    private IBeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerByID(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveBeer(@RequestBody BeerDto beer){
        BeerDto newBeer = beerService.saveNewBeer(beer);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newBeer.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Object> updateBeer(@PathVariable UUID beerId, @RequestBody BeerDto beerDto){
        BeerDto updatedBeer = beerService.updateBeerById(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
