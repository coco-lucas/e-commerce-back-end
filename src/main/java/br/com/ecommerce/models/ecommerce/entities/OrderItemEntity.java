package br.com.ecommerce.models.ecommerce.entities;

import org.springframework.data.mongodb.core.index.Indexed;

public class OrderItemEntity {
    @Indexed(name = "product_id_index")
    private Long productId;

    private Integer quantity;

    public OrderItemEntity() {

    }

    public OrderItemEntity(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
