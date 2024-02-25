package com.example.crud.domain.product;

public record ResposeProductDTO(String name, Integer price_in_cents){

    public ResposeProductDTO(String name, Integer price_in_cents){
        this.name = name;
        this.price_in_cents = price_in_cents;
    }
}
