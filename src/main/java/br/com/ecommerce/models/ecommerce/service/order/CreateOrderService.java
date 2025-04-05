package br.com.ecommerce.models.ecommerce.service.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerce.models.ecommerce.entities.OrderEntity;
import br.com.ecommerce.models.ecommerce.entities.OrderItemEntity;
import br.com.ecommerce.models.ecommerce.listener.order.dto.OrderCreatedEvent;
import br.com.ecommerce.models.ecommerce.listener.order.repository.OrderRepository;
import br.com.ecommerce.models.ecommerce.service.product.ProductService;

@Service
public class CreateOrderService {
    private final OrderRepository repository;
    private final ProductService productService;

    public CreateOrderService(OrderRepository orderRepository, ProductService service) {
        this.repository = orderRepository;
        this.productService = service;
    }

    public void save(OrderCreatedEvent event) {
        OrderEntity entity = new OrderEntity();
        entity.setId(event.idOrder());
        entity.setCustomerId(event.idClient());
        entity.setItens(getOrderItens(event));
        entity.setTotal(getTotal(event));
        entity.setOrderTime(LocalDateTime.now());

        repository.save(entity);
    }

    public static List<OrderItemEntity> getOrderItens(OrderCreatedEvent event) {
        return event.itens()
                .stream()
                .map(i -> new OrderItemEntity(i.idProduct(), i.quantity()))
                .toList();
    }

    public BigDecimal getTotal(OrderCreatedEvent event) {
        return event.itens()
                .stream()
                .map(i -> {
                    var product = productService.getProductById(i.idProduct());
                    return product.get().unitaryPrice().multiply(BigDecimal.valueOf(i.quantity()));
                })
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
