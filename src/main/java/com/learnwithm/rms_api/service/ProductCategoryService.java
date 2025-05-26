package com.learnwithm.rms_api.service;

import com.learnwithm.rms_api.entity.ProductCategory;
import com.learnwithm.rms_api.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository categoryRepository;

    @Autowired
    public ProductCategoryService(ProductCategoryRepository repository) {
        categoryRepository = repository;
    }

    /**
     * create a product category
     *
     * @param category product category data
     * @return the created product category
     */
    public ProductCategory create(ProductCategory category) {
        ProductCategory created = categoryRepository.save(category);
        return created;
    }

    /**
     * update product category
     *
     * @param id       ID of the existing product category
     * @param category updatable category data
     * @return updated product category
     */
    public ProductCategory update(Long id, ProductCategory category) {
        Optional<ProductCategory> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            ProductCategory existing = optionalCategory.get();
            ProductCategory updated = updateCategoryData(existing, category);
            return updated;
        } else {
            throw new RuntimeException("No existing product category found for the given id");
        }
    }


    /**
     * get all product categories
     *
     * @return list of all product categories
     */
    public List<ProductCategory> getAll() {
        return categoryRepository.findAll();
    }

    /**
     * get product category for given id
     *
     * @param id Id of the required product category
     * @return the product category for given id
     */
    public ProductCategory getById(Long id) {
        Optional<ProductCategory> optionalProductCategory = categoryRepository.findById(id);
        if (optionalProductCategory.isPresent()) {
            return optionalProductCategory.get();
        } else {
            throw new RuntimeException("No product category found");
        }
    }

    /**
     * delete an existing product category
     *
     * @param id ID of the deleting product category
     */
    public void deleteProductCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    /**
     * update product category data object
     *
     * @param existing existing category data
     * @param current  new category data
     * @return updated category data
     */
    private ProductCategory updateCategoryData(ProductCategory existing, ProductCategory current) {
        existing.setDescription(current.getDescription());
        existing.setName(current.getName());

        return existing;
    }

}
