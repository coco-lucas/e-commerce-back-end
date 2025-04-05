package br.com.ecommerce.models.ecommerce.controller.dto.product;

import java.math.BigDecimal;

public record ProductResponse(
                Long productId,
                String productName,
                String productDescription,
                String category,
                BigDecimal unitaryPrice) {
}
