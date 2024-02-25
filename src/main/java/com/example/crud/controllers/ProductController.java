package com.example.crud.controllers;

import java.util.List;
import jakarta.validation.Valid;
import com.example.crud.domain.product.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.crud.domain.product.exception.ProductNotFound;


@RestController
@RequestMapping("/product")
public class ProductController {

    // Mover a lógica de product para dentro de uma classe service para aumentar o desacoplamento

    private final ProductRepository repository;

    public ProductController(ProductRepository repository){ this.repository = repository; }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> AllProducts = repository.findAll();
        return ResponseEntity.ok(AllProducts);
    }

    @PostMapping("/add")
    public ResponseEntity createProduct(@RequestBody @Valid RequestProductDTO data){
        Product newProduct = new Product(data);
        repository.save(newProduct);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<ResposeProductDTO> viewProduct(@PathVariable String id) throws ProductNotFound {
        Product view_product = repository.findById(id).orElseThrow(ProductNotFound::new);

        ResposeProductDTO response = new ResposeProductDTO(
                view_product.getName(), view_product.getPrice_in_cents()
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ResposeProductDTO> updateProduct(@PathVariable String id, @RequestBody RequestPutProductDTO data) throws ProductNotFound {
        Product product_recover = repository.findById(id).orElseThrow(ProductNotFound::new);

        if( data.name() != null )  product_recover.setName(data.name());
        if( data.price_int_cents() != null ) product_recover.setPrice_in_cents(data.price_int_cents());

        repository.save(product_recover);
        ResposeProductDTO response = new ResposeProductDTO(
                product_recover.getName(), product_recover.getPrice_in_cents()
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id) throws ProductNotFound {
        Product product_to_delete = repository.findById(id)
                                    .orElseThrow(ProductNotFound::new);

        repository.delete(product_to_delete);
        return ResponseEntity.ok().build();
    }
}
