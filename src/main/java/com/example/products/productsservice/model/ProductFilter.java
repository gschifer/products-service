package com.example.products.productsservice.model;

import jakarta.persistence.criteria.Predicate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductFilter {

    private String brand;
    private String category;
    private String color;
    private String availability;

    public Specification<Product> toSpecification() {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (brand != null) {
                predicates.add(builder.equal(root.get("brand"), brand));
            }

            if (category != null) {
                predicates.add(builder.equal(root.get("category"), category));
            }

            if (color != null) {
                predicates.add(builder.equal(root.get("color"), color));
            }

            if (availability != null) {
                predicates.add(builder.equal(root.get("availability"), availability));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}


