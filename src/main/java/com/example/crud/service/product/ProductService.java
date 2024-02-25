package com.example.crud.service.product;

import com.example.crud.domain.product.*;
import com.example.crud.domain.product.exception.ProductNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    // classe responsável por desacoplar o controller do repository.

    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public ResponseProductDTO create(RequestProductDTO data){
        Product newProduct = new Product(data);
        repository.save(newProduct);

        return newProduct.getResponse();
    }

    public List<Product> getAll(){
        return this.repository.findAll();
    }

    public ResponseProductDTO getView(String id) throws ProductNotFound {
        Product product = this.repository.findById(id).orElseThrow(ProductNotFound::new);
        return product.getResponse();
    }

    public ResponseProductDTO update(String id, RequestPutProductDTO data) throws ProductNotFound{
        Product product = this.repository.findById(id).orElseThrow(ProductNotFound::new);

        if( data.name() != null )  product.setName(data.name());
        if( data.price_in_cents() != null ) product.setPrice_in_cents(data.price_in_cents());

        repository.save(product);

        return product.getResponse();
    }

    public ResponseEntity<ResponseEntity.BodyBuilder> delete(String id) throws ProductNotFound {
        Product product_to_delete = repository.findById(id)
                                              .orElseThrow(ProductNotFound::new);
        repository.delete(product_to_delete);
        return ResponseEntity.ok().build();
    }
}
