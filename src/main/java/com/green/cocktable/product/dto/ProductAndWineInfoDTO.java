package com.green.cocktable.product.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ProductAndWineInfoDTO {

    private String productCode;
    private String categoryCode;
    private String name;
    private String englishName;
    private int price;
    private String description;
    private char salesYn;
    private char displayYn;
    private List<ProductImageDTO> productIMGList;
    private List<WineInfoDTO> wineInfo;
}
