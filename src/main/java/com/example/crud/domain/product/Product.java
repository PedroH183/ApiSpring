package com.example.crud.domain.product;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "product")
@Entity(name = "product") // definição de entidade !
@Getter
@Setter
@AllArgsConstructor // cria um construtor em tempo de execução que recebe todos os argumentos
@NoArgsConstructor // criar um construtor em tempo de execução que não recebe nenhum parametro
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // gerar valores automaticamente
    private String id;
    private String name;
    private Integer price_in_cents;

    public Product( RequestProductDTO data ){
        this.name = data.name();
        this.price_in_cents = data.price_in_cents();
    }
}


