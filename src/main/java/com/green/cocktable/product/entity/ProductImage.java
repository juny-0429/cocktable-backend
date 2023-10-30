package com.green.cocktable.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DynamicInsert
@Entity
@Table(name = "TBL_COCK_PRODUCT_IMG")
public class ProductImage {

    @Id
    @Column(name = "PRODUCT_IMG_CODE")
    private String imageCode;

    @Column(name = "PRODUCT_CODE")
    private String productCode;

    @Column(name = "PRODUCT_IMG_ORIGIN_NAME")
    private String imageOriginName;

    @Column(name = "PRODUCT_IMG_CHANGE_NAME")
    private String imageChangeName;

    @Column(name = "PRODUCT_IMG_TYPE")
    private String imageType;

    @Column(name = "PRODUCT_IMG_LOCATION")
    private String imageLocation;

    @Column(name = "PRODUCT_IMG_CREATE_DATE")
    private Date imageCreateDate;

    @Column(name = "PRODUCT_IMG_DELETE_YN")
    private char imageDeleteYn;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_CODE", insertable = false, updatable = false)
    private Product product;

    @Override
    public String toString() {
        return "ProductImage{" +
                "imageCode='" + imageCode + '\'' +
                ", productCode='" + productCode + '\'' +
                ", imageOriginName='" + imageOriginName + '\'' +
                ", imageChangeName='" + imageChangeName + '\'' +
                ", imageType='" + imageType + '\'' +
                ", imageLocation='" + imageLocation + '\'' +
                ", imageCreateDate=" + imageCreateDate +
                ", imageDeleteYn=" + imageDeleteYn +
                '}';
    }
}
