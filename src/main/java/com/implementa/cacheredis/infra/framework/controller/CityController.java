package com.implementa.cacheredis.infra.framework.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.implementa.cacheredis.application.usecase.cityusecase.FindCity;
import com.implementa.cacheredis.application.usecase.cityusecase.SaveCity;
import com.implementa.cacheredis.domain.entity.city.City;
import com.implementa.cacheredis.domain.entity.city.CityBuilder;
import com.implementa.cacheredis.infra.dto.CityDtoPost;

@RestController
@RequestMapping("/v1/city")
public class CityController {
    


    private final FindCity findCity;
    private final SaveCity saveCity;

    public CityController( FindCity findCity, SaveCity saveCity){
        this.findCity = findCity;
        this.saveCity = saveCity;
        
    }


    @PostMapping
    ResponseEntity<City> findById( @RequestBody CityDtoPost cityDtoPost){

        return ResponseEntity.ok(this.saveCity.useCaseSave( new CityBuilder().cityBuilderWithState(cityDtoPost.description(), cityDtoPost.zipCode(), cityDtoPost.stateId()) ));
    }


    @GetMapping
    ResponseEntity<List<City>> findAllCity(){

        return ResponseEntity.ok(this.findCity.useCaseFindAllCity());
        
    }

    @GetMapping("/{id}")
    ResponseEntity<City> findById( @PathVariable Long id){

        return ResponseEntity.ok(this.findCity.useCaseFindACityById(id));
    }

}
