package com.example.crud.controllers;

import java.util.List;

import com.example.crud.service.product.ProductService;
import jakarta.validation.Valid;
import com.example.crud.domain.product.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.crud.domain.product.exception.ProductNotFound;


@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service){ this.service = service; }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> AllProducts = this.service.getAll();
        return ResponseEntity.ok(AllProducts);
    }

    @PostMapping("/add")
    public ResponseProductDTO createProduct(@RequestBody @Valid RequestProductDTO data){
        return this.service.create(data);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<ResponseProductDTO> viewProduct(@PathVariable String id) throws ProductNotFound {
        return ResponseEntity.ok().body(this.service.getView(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ResponseProductDTO> updateProduct(@PathVariable String id, @RequestBody RequestPutProductDTO data) throws ProductNotFound {
        ResponseProductDTO response = this.service.update(id, data);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseEntity.BodyBuilder> deleteProduct(@PathVariable String id) throws ProductNotFound {
        return this.service.delete(id);
    }
}
