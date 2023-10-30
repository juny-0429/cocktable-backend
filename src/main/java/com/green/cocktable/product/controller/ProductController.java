package com.green.cocktable.product.controller;

import com.green.cocktable.product.dto.ProductDTO;
import com.green.cocktable.product.service.ProductService;
import com.green.cocktable.commons.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhosml:3000")
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "상품 리스트 조회 요청", description = "상품 리스트를 조회하여 가지고 옵니다.", tags = {"Product"})
    @GetMapping("/productList/{categoryCode}")
    public ResponseEntity<ResponseDTO> productListAllPrint(@PathVariable String categoryCode) {

        List<ProductDTO> productList = productService.productList(categoryCode);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공",(Object) productList));
    }
}
