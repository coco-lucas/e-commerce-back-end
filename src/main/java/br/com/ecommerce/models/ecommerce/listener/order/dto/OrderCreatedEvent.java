package br.com.ecommerce.models.ecommerce.listener.order.dto;

import java.util.List;

public record OrderCreatedEvent(
                Long idOrder,
                Long idClient,
                List<OrderItemEvent> itens) {
}
