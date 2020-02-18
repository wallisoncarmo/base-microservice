package com.microservice.trade.domain.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PhoneType {

    COMERCIAL("COMERCIAL"),
    CELULAR("CELULAR"),
    RESIDENCIAL("RESIDENCIAL");

    private String description;
}