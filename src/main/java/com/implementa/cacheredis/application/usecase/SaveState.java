package com.implementa.cacheredis.application.usecase;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;

import com.implementa.cacheredis.domain.entity.state.State;


public interface SaveState {
    
    State saveState(State state);
    


}
