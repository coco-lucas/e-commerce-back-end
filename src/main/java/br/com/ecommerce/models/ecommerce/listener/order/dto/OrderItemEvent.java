package br.com.ecommerce.models.ecommerce.listener.order.dto;

public record OrderItemEvent(
                Long idProduct,
                Integer quantity) {
}
