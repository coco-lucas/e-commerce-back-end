package br.com.ecommerce.models.ecommerce.controller.dto.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponse(
        Long orderId,
        Long customerId,
        BigDecimal total,
        LocalDateTime orderTime) {

}
