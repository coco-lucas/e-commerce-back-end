package br.com.ecommerce.models.ecommerce.entities;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "tb_product")
public class ProductEntity {
    @MongoId
    private Long id;

    private String productName;

    private String productDescription;

    private String category;

    private BigDecimal unitaryPrice;

    public ProductEntity() {

    }

    public ProductEntity(Long id, String productName, String productDescription, String category,
            BigDecimal unitaryPrice) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.category = category;
        this.unitaryPrice = unitaryPrice;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getUnitaryPrice() {
        return this.unitaryPrice;
    }

    public void setUnitaryPrice(BigDecimal unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }
}
