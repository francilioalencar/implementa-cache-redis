package com.implementa.cacheredis.infra.framework.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.implementa.cacheredis.application.gateways.CityRepository;
import com.implementa.cacheredis.domain.entity.city.City;
import com.implementa.cacheredis.domain.entity.city.CityBuilder;
import com.implementa.cacheredis.domain.entity.state.State;
import com.implementa.cacheredis.infra.framework.model.CityEntity;
import com.implementa.cacheredis.infra.framework.model.StateEntity;


@Service

public class CiteRepositoryImplements implements CityRepository {

    private final CityEntityRepository cityEntityRepository;
    private final StateRepositoryImplements stateRepositoryImplements;

    public CiteRepositoryImplements(CityEntityRepository cityEntityRepository, StateRepositoryImplements stateRepositoryImplements){
        this.cityEntityRepository = cityEntityRepository;
        this.stateRepositoryImplements = stateRepositoryImplements;
    }


    @Override
    public City saveInJpa(City city) {
        

        State state = this.stateRepositoryImplements.findByIdInJpa(city.getStateId());

        StateEntity stateEntity =  StateEntity.builder()
            .id(state.getId())
            .description(state.getDescription())
            .acronym(state.getAcronym())
            .build();


        CityEntity cityEntity = CityEntity.builder()
            
            .description(city.getDescription())
            .stateEntity(stateEntity)
            .zipCode(city.getZipCode())
            .build();


        return  new CityBuilder().cityByCityEntity( this.cityEntityRepository.save(cityEntity) );
        
    }

    @Override
    public City findByIdInJpa(Long id) {
        
        return new CityBuilder().cityByCityEntity( this.cityEntityRepository.findById(id).orElseThrow(NoSuchElementException::new) );

    }

    @Override
    public List<City> findAllInJpa() {
        // TODO Auto-generated method stub
        List<City> cities = new ArrayList<>();

        this.cityEntityRepository.findAll().forEach(item->{

            cities.add(new CityBuilder().cityByCityEntity(item));

        });

        return cities;
    }
    
}
