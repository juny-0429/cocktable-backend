package com.green.cocktable.product.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class WineInfoDTO {

    private String wineCode;
    private String productCode;
    private int wineABV;
    private String wineOrigin;
    private int wineAcidity;
    private int wineSweetness;
    private int wineBody;
    private int wineTannin;
    private String wineType;
}
