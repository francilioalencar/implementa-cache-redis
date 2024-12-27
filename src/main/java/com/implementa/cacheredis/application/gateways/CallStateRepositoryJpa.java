package com.implementa.cacheredis.application.gateways;

import java.util.List;

import com.implementa.cacheredis.domain.entity.state.State;

public interface CallStateRepositoryJpa {

    State saveInJpa(State state);

    List<State> findAllInJpa();
    State findByIdInJpa(Long id);
    

    
}