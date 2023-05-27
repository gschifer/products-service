package com.example.products.productsservice.specifications;

import com.example.products.productsservice.model.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {

    public static Specification<Product> hasBrand(String brand) {
        return (root, query, builder) -> builder.equal(root.get("brand"), brand);
    }

    public static Specification<Product> hasCategory(String category) {
        return (root, query, builder) -> builder.equal(root.get("category"), category);
    }

    public static Specification<Product> hasColor(String color) {
        return (root, query, builder) -> builder.equal(root.get("color"), color);
    }

    public static Specification<Product> hasAvailability(String availability) {
        return (root, query, builder) -> builder.equal(root.get("availability"), availability);
    }

}

