package br.com.ecommerce.models.ecommerce.controller;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.models.ecommerce.controller.dto.ApiResponse;
import br.com.ecommerce.models.ecommerce.controller.dto.PaginationResponse;
import br.com.ecommerce.models.ecommerce.controller.dto.order.OrderResponse;
import br.com.ecommerce.models.ecommerce.service.order.CreateOrderService;
import br.com.ecommerce.models.ecommerce.service.order.OrderRetrievalService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    private final CreateOrderService createOrder;
    private final OrderRetrievalService retrieveOrder;

    public OrderController(CreateOrderService createOrder, OrderRetrievalService retrieveOrder) {
        this.createOrder = createOrder;
        this.retrieveOrder = retrieveOrder;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<OrderResponse>> listOrders(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<OrderResponse> pageResponse = retrieveOrder.findAllOrders(PageRequest.of(page, pageSize));

        return ResponseEntity.ok(new ApiResponse<>(
                Map.of("", null),
                pageResponse.getContent(),
                PaginationResponse.fromPage(pageResponse)));
    }

    // finish list by costumer
    // public ResponseEntity<ApiResponse<OrderResponse>> listOrdersByCostumer(
    // @PathVariable("customerId") Long customerId,
    // @RequestParam(name = "page", defaultValue = "0") Integer page,
    // @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
    // }

}
