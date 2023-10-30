package com.green.cocktable.product.repository;

import com.green.cocktable.product.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, String> {

    List<ProductImage> findByProductCode(String productCode);
}
