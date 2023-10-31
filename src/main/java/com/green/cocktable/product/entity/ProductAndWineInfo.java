package com.green.cocktable.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_COCK_PRODUCT")
@DynamicInsert
public class ProductAndWineInfo {

    @Id
    @Column(name = "PRODUCT_CODE")
    private String productCode;

    @Column(name = "CATEGORY_CODE")
    private String categoryCode;

    @Column(name = "PRODUCT_NAME")
    private String name;

    @Column(name = "PRODUCT_ENGLISH_NAME")
    private String englishName;

    @Column(name = "PRODUCT_PRICE")
    private int price;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String description;

    @Column(name = "SALES_YN")
    private char salesYn;

    @Column(name = "DISPLAY_YN")
    private char displayYn;

    @OneToMany
    @JoinColumn(name = "PRODUCT_CODE")
    private List<ProductImage> productImages;

    @OneToMany
    @JoinColumn(name = "PRODUCT_CODE")
    private List<WineInfo> wineInfo;

    @Override
    public String toString() {
        return "ProductAndWineInfo{" +
                "productCode='" + productCode + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", name='" + name + '\'' +
                ", englishName='" + englishName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", salesYn=" + salesYn +
                ", displayYn=" + displayYn +
                ", productImages=" + productImages +
                ", wineInfo=" + wineInfo +
                '}';
    }
}
