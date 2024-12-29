package com.implementa.cacheredis.application.usecase;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.implementa.cacheredis.application.gateways.StateRepository;
import com.implementa.cacheredis.domain.entity.state.State;

public class FindStateImplements implements FindState {


    private final StateRepository stateRepository;

    public FindStateImplements(StateRepository stateRepository){
        this.stateRepository =  stateRepository;

    }

    @Override
    public State useCaseFindById(Long id) {
         return this.stateRepository.findByIdInJpa(id); 
       
    }

    @Override
    public List<State> useCaseFindAll() {

        
        
        return this.stateRepository.findAllInJpa() ;

    }
    
}
