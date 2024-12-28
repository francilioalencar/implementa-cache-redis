package com.implementa.cacheredis.infra.dto;

public record CityDtoPost(
    String description,
    String zipCode,
    Long stateId
) {
    
}
