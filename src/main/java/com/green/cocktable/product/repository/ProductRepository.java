package com.green.cocktable.product.repository;

import com.green.cocktable.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findAll();

    List<Product> findByCategoryCodeAndSalesYn(String categoryCode, char salesYn);
}
