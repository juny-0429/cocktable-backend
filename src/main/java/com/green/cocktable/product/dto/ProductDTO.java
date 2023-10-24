package com.green.cocktable.product.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ProductDTO {

    private String productCode;
    private String categoryCode;
    private String name;
    private String englishName;
    private int price;
    private String description;
    private String image;
    private char salesYn;
    private char displayYn;
}
