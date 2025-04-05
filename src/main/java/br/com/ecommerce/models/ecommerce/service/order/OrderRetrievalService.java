package br.com.ecommerce.models.ecommerce.service.order;

import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.ecommerce.models.ecommerce.controller.dto.order.OrderResponse;
import br.com.ecommerce.models.ecommerce.listener.order.repository.OrderRepository;

@Service
public class OrderRetrievalService {

    private final ModelMapper modelMapper;
    public final OrderRepository repository;

    public OrderRetrievalService(OrderRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public Page<OrderResponse> findAllOrders(PageRequest pageRequest) {
        var orders = repository.findAll().stream().map(o -> modelMapper.map(o, OrderResponse.class))
                .collect(Collectors.toList());
        Page<OrderResponse> pageableOrders = new PageImpl<>(orders);

        return pageableOrders;
    }

}
