package com.example.crud.domain.product;

public record ResponseProductDTO(String name, Integer price_in_cents){

    public ResponseProductDTO(String name, Integer price_in_cents){
        this.name = name;
        this.price_in_cents = price_in_cents;
    }
}
