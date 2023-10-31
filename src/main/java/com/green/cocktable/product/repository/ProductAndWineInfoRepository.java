package com.green.cocktable.product.repository;

import com.green.cocktable.product.entity.ProductAndWineInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductAndWineInfoRepository extends JpaRepository<ProductAndWineInfo, String> {

    List<ProductAndWineInfo> findByCategoryCodeAndSalesYn(String categoryCode, char salesYn);
}
