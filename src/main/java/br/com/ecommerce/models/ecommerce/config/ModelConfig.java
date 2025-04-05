package br.com.ecommerce.models.ecommerce.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // add more specifics typeMaps here in the future
        /*
         * Function ex.:
         * 
         * modelMapper.typeMap(dto.class, entity.class)
         * .addMapping(mapper -> mapper.skip(entity.setId));
         */

        return new ModelMapper();
    }
}
