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

    @Value("http://localhost:8888/productImages/")
    private String PRODUCT_IMAGE_URL;

    private String getCategoryImageSubdirectory(String categoryCode) {
        // 카테고리 코드를 기반으로 이미지 서브 디렉토리 결정
        switch (categoryCode) {
            case "category1":
                return "cocktail/";
            case "category2":
                return "wine/";
            case "category3":
                return "food/";
            case "category4":
                return "DRINK/";
            default:
                return "unknown/";
        }
    }

    /* 상품 리스트 조회 */
    public List<ProductDTO> productList(String categoryCode) {
        List<Product> ProductList = productRepository.findByCategoryCodeAndSalesYn(categoryCode, 'Y');

        String imageUrl = PRODUCT_IMAGE_URL + getCategoryImageSubdirectory(categoryCode);

        List<ProductDTO> productDTOList = ProductList.stream()
                .map(product -> {
                    List<ProductImage> images = productImageRepository.findByProductCodeAndImageDeleteYn(product.getProductCode(), 'N');

                    ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
                    productDTO.setProductIMGList(images.stream()
                            .map(image -> {
                                image.setImageLocation(imageUrl + image.getImageChangeName() + image.getImageType());
                                return modelMapper.map(image, ProductImageDTO.class);
                            })
                            .collect(Collectors.toList()));

                    return productDTO;
                })
                .collect(Collectors.toList());

        return productDTOList;
    }
}