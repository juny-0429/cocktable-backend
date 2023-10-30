package com.green.cocktable.product.repository;

import com.green.cocktable.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    /* 상품리스트 가져오기 (삭제 표시된 상품은 제외) */
    List<Product> findByCategoryCodeAndSalesYn(String categoryCode, char salesYn);
}
