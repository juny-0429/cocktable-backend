package com.green.cocktable.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_WINE_INFO")
@DynamicInsert
public class WineInfo {

    @Id
    @Column(name = "PRODUCT_WINE_CODE")
    private String wineCode;

    @Column(name = "PRODUCT_CODE")
    private String productCode;

    @Column(name = "WINE_ABV")
    private int wineABV;

    @Column(name = "WINE_ORIGIN")
    private String wineOrigin;

    @Column(name = "WINE_ACIDITY")
    private int wineAcidity;

    @Column(name = "WINE_SWEETNESS")
    private int wineSweetness;

    @Column(name = "WINE_BODY")
    private int wineBody;

    @Column(name = "WINE_TANNIN")
    private int wineTannin;

    @Column(name = "WINE_TYPE")
    private String wineType;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_CODE", insertable = false, updatable = false)
    private ProductAndWineInfo product;

    @Override
    public String toString() {
        return "WineInfo{" +
                "wineCode='" + wineCode + '\'' +
                ", productCode='" + productCode + '\'' +
                ", wineABV=" + wineABV +
                ", wineOrigin='" + wineOrigin + '\'' +
                ", wineAcidity=" + wineAcidity +
                ", wineSweetness=" + wineSweetness +
                ", wineBody=" + wineBody +
                ", wineTannin=" + wineTannin +
                ", wineType='" + wineType + '\'' +
                '}';
    }
}
