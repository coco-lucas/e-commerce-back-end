package br.com.ecommerce.models.ecommerce.service.product;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.ecommerce.models.ecommerce.controller.dto.product.ProductResponse;
import br.com.ecommerce.models.ecommerce.entities.ProductEntity;
import br.com.ecommerce.models.ecommerce.listener.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ModelMapper modelMapper;
    private ProductRepository repository;

    public ProductService(ProductRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public Optional<ProductResponse> getProductById(Long id) {
        return repository.findById(id)
                .map(p -> modelMapper.map(ProductEntity.class, ProductResponse.class));
    }
}
