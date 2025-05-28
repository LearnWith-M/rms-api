package com.learnwithm.rms_api.service;

import com.learnwithm.rms_api.entity.Product;
import com.learnwithm.rms_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * create a new product
     *
     * @param product product data
     * @return created product data
     */
    public Product create(Product product) {
        return productRepository.save(product);
    }

    /**
     * get all product data
     *
     * @return list of product data response
     */
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    /**
     * get product data for a given id
     *
     * @param id id of the product
     * @return product data response
     */
    public Product getById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new RuntimeException("No product is present for given id");
        }
    }

    /**
     * delete a product for given id
     *
     * @param id id of the product
     */
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
