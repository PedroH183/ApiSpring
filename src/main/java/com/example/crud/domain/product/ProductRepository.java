package com.example.crud.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {}
// É uma interface que funcionará entre a logica de acesso ao banco de dados e
// minhas regras de negócio.
