package com.implementa.cacheredis.application.usecase;

import org.springframework.cache.annotation.CacheEvict;

import com.implementa.cacheredis.application.gateways.StateRepository;
import com.implementa.cacheredis.domain.entity.state.State;

public class SaveStateImplements implements SaveState{

    private final StateRepository callStateRepositoryJpa;

    public SaveStateImplements(StateRepository callStateRepositoryJpa){
        this.callStateRepositoryJpa = callStateRepositoryJpa;

    }

   
    @Override
    public State saveState(State state) {
        
       return this.callStateRepositoryJpa.saveInJpa(state);


    }

  

}
