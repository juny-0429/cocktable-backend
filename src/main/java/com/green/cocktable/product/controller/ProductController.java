package com.green.cocktable.product.controller;

import com.green.cocktable.product.dto.ProductDTO;
import com.green.cocktable.product.service.ProductService;
import com.green.cocktable.commons.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @Operation(summary = "상품 전체 조회 요청", description = "전체 상품을 조회하여 가지고 옵니다.", tags = {"Product"})
    @GetMapping("/test")
    public ResponseEntity<ResponseDTO> productListAllPrint() {

        List<ProductDTO> productList = productService.listAll();

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공",(Object) productList));
    }

    @Operation(summary = "칵테일 상품 조회 요청", description = "칵테일 상품을 조회하여 가지고 옵니다.", tags = {"Product"})
    @GetMapping("/cocktail")
    public ResponseEntity<ResponseDTO> cocktailListAllPrint() {

        List<ProductDTO> productList = productService.cocktailList();

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공",(Object) productList));
    }

}
