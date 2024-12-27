package com.implementa.cacheredis.application.usecase;

import java.util.List;

import com.implementa.cacheredis.domain.entity.state.State;

public interface SaveState {
    
    State saveState(State state);
    


}
