package com.prueba.inditex.infrastructure.adapters.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.prueba.inditex.domain.service.PriceService;
import com.prueba.inditex.infrastructure.adapters.output.persistence.PricePersistenceAdapter;
import com.prueba.inditex.infrastructure.adapters.output.persistence.mapper.PricePersistenceMapper;
import com.prueba.inditex.infrastructure.adapters.output.persistence.repository.PriceRepository;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PricePersistenceAdapter pricePersistenceAdapter(PriceRepository priceRepository, PricePersistenceMapper pricePersistenceMapper) {
        return new PricePersistenceAdapter(priceRepository, pricePersistenceMapper);
    }  

    @Bean
    public PriceService priceService(PricePersistenceAdapter pricePersistenceAdapter) {
        return new PriceService(pricePersistenceAdapter);
    }
    





}
