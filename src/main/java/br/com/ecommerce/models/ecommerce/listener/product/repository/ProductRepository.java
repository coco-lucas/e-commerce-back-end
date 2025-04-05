package br.com.ecommerce.models.ecommerce.listener.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ecommerce.models.ecommerce.entities.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity, Long> {

}
