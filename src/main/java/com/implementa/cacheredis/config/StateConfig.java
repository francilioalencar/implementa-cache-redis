package com.implementa.cacheredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.implementa.cacheredis.application.gateways.CallStateRepositoryJpa;
import com.implementa.cacheredis.application.usecase.FindStateImplements;
import com.implementa.cacheredis.application.usecase.SaveStateImplements;

@Configuration
public class StateConfig {

    @Bean
    public FindStateImplements findStateImplements(CallStateRepositoryJpa callStateRepositoryJpa){
        return new FindStateImplements(callStateRepositoryJpa);
    }
    



    @Bean
    public SaveStateImplements saveStateImplements(CallStateRepositoryJpa callStateRepositoryJpa){

        return new SaveStateImplements(callStateRepositoryJpa);

    }



}
