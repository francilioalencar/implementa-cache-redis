package com.implementa.cacheredis.application.usecase;

import java.util.List;

import com.implementa.cacheredis.domain.entity.state.State;

public interface FindState {
    
    State useCaseFindById(Long id);
    List<State> useCaseFindAll();


}
