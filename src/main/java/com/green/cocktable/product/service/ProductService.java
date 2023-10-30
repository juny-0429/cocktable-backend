package com.green.cocktable.product.service;

import com.green.cocktable.product.dto.ProductDTO;
import com.green.cocktable.product.dto.ProductImageDTO;
import com.green.cocktable.product.entity.Product;
import com.green.cocktable.product.entity.ProductImage;
import com.green.cocktable.product.repository.ProductImageRepository;
import com.green.cocktable.product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    private final ProductImageRepository productImageRepository;

    @Autowired
    public ProductService(ModelMapper modelMapper, ProductRepository productRepository, ProductImageRepository productImageRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.productImageRepository = productImageRepository;
    }

    @Value("src/main/resources/static/productImage/food")
    private String FOOD_IMAGE_DIR;

    @Value("http://localhost:8888/productImages/food/")
    private String FOOD_IMAGE_URL;

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

    /* 와인 상품 전체 조회 */
    public List<ProductDTO> wineList() {

        List<Product> category2Products = productRepository.findByCategoryCode("category2");

        return category2Products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    /* 음식 상품 전체 조회 */
    public List<ProductDTO> foodList() {

        List<Product> category3Products = productRepository.findByCategoryCode("category3");

        List<ProductDTO> productDTOList = category3Products.stream()
                .map(product -> {
                    List<ProductImage> images = productImageRepository.findByProductCode(product.getProductCode());

                    // ProductDTO에 이미지 설정
                    ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
                    productDTO.setProductIMGList(images.stream()
                            .map(image -> {
                                // 이미지 URL 합치기
                                image.setImageLocation(FOOD_IMAGE_URL + image.getImageChangeName() + image.getImageType());
                                return modelMapper.map(image, ProductImageDTO.class);
                            })
                            .collect(Collectors.toList()));

                    return productDTO;
                })
                .collect(Collectors.toList());

        return productDTOList;

    }

    /* 음료 상품 전체 조회 */
    public List<ProductDTO> drinkList() {

        List<Product> category4Products = productRepository.findByCategoryCode("category4");

        return category4Products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }
}