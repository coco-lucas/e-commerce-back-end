package br.com.ecommerce.models.ecommerce.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "tb_orders")
public class OrderEntity {
    @MongoId
    private Long id;

    @Indexed(name = "customer_id_index")
    private Long customerId;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal total;

    private List<OrderItemEntity> itens;

    private LocalDateTime orderTime;

    public OrderEntity() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<OrderItemEntity> getItens() {
        return this.itens;
    }

    public void setItens(List<OrderItemEntity> itens) {
        this.itens = itens;
    }

    public LocalDateTime getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
}
