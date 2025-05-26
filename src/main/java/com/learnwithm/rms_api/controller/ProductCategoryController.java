package com.learnwithm.rms_api.controller;

import com.learnwithm.rms_api.entity.ProductCategory;
import com.learnwithm.rms_api.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService categoryService;

    /**
     * get all product categories
     *
     * @return Response entity with status 200(OK) and body of all product categories
     */
    @GetMapping("/")
    public ResponseEntity<List<ProductCategory>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    /**
     * get product category for a given id
     *
     * @param id ID of the required product category
     * @return Response entity with status 200(OK) and body of the required product category
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    /**
     * create a product category
     *
     * @param category category data that need to create
     * @return response entity with status 200(OK) and body of added category
     */
    @PostMapping("/")
    public ResponseEntity<ProductCategory> create(ProductCategory category) {
        return ResponseEntity.ok(categoryService.create(category));
    }

    /**
     * update an existing product category
     *
     * @param id      ID of the product category
     * @param updated updatable data of product category
     * @return response entity with status 200(OK) and body of updated category
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProductCategory> update(@PathVariable(value = "id") Long id, ProductCategory updated) {
        return ResponseEntity.ok(categoryService.update(id, updated));
    }


    /**
     * delete an existing product category
     *
     * @param id ID of the deletable product category
     * @return response entity with status 200(OK)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(value = "id") Long id) {
        categoryService.deleteProductCategory(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
