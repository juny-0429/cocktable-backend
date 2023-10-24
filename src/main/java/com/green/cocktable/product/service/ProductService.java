package com.green.cocktable.product.service;

import com.green.cocktable.product.dto.ProductDTO;
import com.green.cocktable.product.entity.Product;
import com.green.cocktable.product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ModelMapper modelMapper, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }


    public List<ProductDTO> listAll() {

        List<Product> productList = productRepository.findAll();

        return productList.stream().map(product -> modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());
    }

    /* 칵테일 상품 전체 조회 */
    public List<ProductDTO> cocktailList() {
        List<Product> category1Products = productRepository.findByCategoryCode("category1");

        return category1Products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }
}
