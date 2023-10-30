package com.green.cocktable.product.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ProductImageDTO {

    private String imageCode;
    private String productCode;
    private String imageOriginName;
    private String imageChangeName;
    private String imageType;
    private String imageLocation;
    private Date imageCreateDate;
    private char imageDeleteYN;
}
