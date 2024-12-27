package com.implementa.cacheredis.application.usecase;

import java.util.List;

import com.implementa.cacheredis.application.gateways.CallStateRepositoryJpa;
import com.implementa.cacheredis.domain.entity.state.State;

public class FindStateImplements implements FindState {


    private final CallStateRepositoryJpa callStateRepositoryJpa;

    public FindStateImplements(CallStateRepositoryJpa callStateRepositoryJpa){
        this.callStateRepositoryJpa =  callStateRepositoryJpa;

    }

    @Override
    public State useCaseFindById(Long id) {
         return this.callStateRepositoryJpa.findByIdInJpa(id); 
       
    }

    @Override
    public List<State> useCaseFindAll() {

        
        
        return this.callStateRepositoryJpa.findAllInJpa() ;

    }
    
}
