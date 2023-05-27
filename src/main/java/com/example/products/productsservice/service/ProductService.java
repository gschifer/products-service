package com.example.products.productsservice.service;

import com.example.products.productsservice.model.Product;
import com.example.products.productsservice.repository.ProductRepository;
import com.example.products.productsservice.specifications.ProductSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProducts(String brand, String category, String color, String availability) {
        Specification<Product> spec = Specification.where(null);

        if ( brand != null && !brand.isEmpty() ) {
            spec = spec.and(ProductSpecifications.hasBrand(brand));
        }

        if ( category != null && !category.isEmpty() ) {
            spec = spec.and(ProductSpecifications.hasCategory(category));
        }

        if ( color != null && !color.isEmpty() ) {
            spec = spec.and(ProductSpecifications.hasColor(color));
        }

        if ( availability != null && !availability.isEmpty() ) {
            spec = spec.and(ProductSpecifications.hasAvailability(availability));
        }

        return productRepository.findAll(spec);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product foundedProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product couldnt be updated"));

        return productRepository.save(foundedProduct);
    }

    public void deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new RuntimeException("Product with this ID doesnt exist");
        }
    }
}
