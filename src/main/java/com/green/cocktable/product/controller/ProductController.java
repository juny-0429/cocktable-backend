package com.green.cocktable.product.controller;

import com.green.cocktable.product.dto.ProductDTO;
import com.green.cocktable.product.service.ProductService;
import com.green.cocktable.commons.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhosml:3000")
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

        System.out.println("여기는 작동하니??");

        List<ProductDTO> productList = productService.cocktailList();

        System.out.println("데이터 확인 = " + productList);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공",(Object) productList));
    }

    @Operation(summary = "와인 상품 조회 요청", description = "와인 상품을 조회하여 가지고 옵니다.", tags = {"Product"})
    @GetMapping("/wine")
    public ResponseEntity<ResponseDTO> wineListAllPrint() {

        List<ProductDTO> productList = productService.wineList();

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공",(Object) productList));
    }

    @Operation(summary = "음식 상품 조회 요청", description = "음식 상품을 조회하여 가지고 옵니다.", tags = {"Product"})
    @GetMapping("/food")
    public ResponseEntity<ResponseDTO> foodListAllPrint() {

        List<ProductDTO> productList = productService.foodList();

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공",(Object) productList));
    }

    @Operation(summary = "음료 상품 조회 요청", description = "음료 상품을 조회하여 가지고 옵니다.", tags = {"Product"})
    @GetMapping("/drink")
    public ResponseEntity<ResponseDTO> drinkListAllPrint() {

        List<ProductDTO> productList = productService.drinkList();

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회성공",(Object) productList));
    }
}
