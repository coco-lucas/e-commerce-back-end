package br.com.ecommerce.models.ecommerce.controller.dto;

import java.util.List;
import java.util.Map;

public record ApiResponse<T>(Map<String, Object> summary, List<?> data, PaginationResponse pagination) {

}
