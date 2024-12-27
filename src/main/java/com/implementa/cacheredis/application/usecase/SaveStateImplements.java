package com.implementa.cacheredis.application.usecase;

import com.implementa.cacheredis.application.gateways.CallStateRepositoryJpa;
import com.implementa.cacheredis.domain.entity.state.State;

public class SaveStateImplements implements SaveState{

    private final CallStateRepositoryJpa callStateRepositoryJpa;

    public SaveStateImplements(CallStateRepositoryJpa callStateRepositoryJpa){
        this.callStateRepositoryJpa = callStateRepositoryJpa;

    }

    @Override
    public State saveState(State state) {
        
       return this.callStateRepositoryJpa.saveInJpa(state);


    }

  

}
