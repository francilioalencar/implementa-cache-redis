package com.implementa.cacheredis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.implementa.cacheredis.application.gateways.StateRepository;
import com.implementa.cacheredis.application.usecase.FindStateImplements;
import com.implementa.cacheredis.application.usecase.SaveStateImplements;

@Configuration
public class StateConfig {

    @Bean
    public FindStateImplements findStateImplements(StateRepository stateRepository){
        return new FindStateImplements(stateRepository);
    }
    



    @Bean
    public SaveStateImplements saveStateImplements(StateRepository stateRepository){

        return new SaveStateImplements(stateRepository);

    }



}
