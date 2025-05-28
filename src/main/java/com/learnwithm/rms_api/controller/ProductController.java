package com.learnwithm.rms_api.controller;

import com.learnwithm.rms_api.entity.Product;
import com.learnwithm.rms_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * get all product data list
     *
     * @return response entity with status 200(OK) and body of product data list
     */
    @GetMapping("/")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    /**
     * get specific product
     *
     * @param id id of the product data
     * @return response entity with status 200(OK) and request product data
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    /**
     * create a new product
     *
     * @param product new product data
     * @return response entity with 200(OK) and created product data
     */
    @PostMapping("/")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.create(product));
    }

    /**
     * delete a product data
     *
     * @param id id of the deleting product
     * @return response entity with 200(OK)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(value = "id") Long id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
