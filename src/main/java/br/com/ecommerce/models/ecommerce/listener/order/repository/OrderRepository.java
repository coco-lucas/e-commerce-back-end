package br.com.ecommerce.models.ecommerce.listener.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ecommerce.models.ecommerce.entities.OrderEntity;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
}
