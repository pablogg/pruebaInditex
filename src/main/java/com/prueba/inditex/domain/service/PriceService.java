package com.prueba.inditex.domain.service;

import com.prueba.inditex.application.ports.input.GetPriceUseCase;

import java.sql.Timestamp;


import com.prueba.inditex.application.ports.input.CreatePriceUseCase;

import com.prueba.inditex.application.ports.output.PriceOutputPort;
import com.prueba.inditex.domain.exception.PriceNotFound;
import com.prueba.inditex.domain.model.Price;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class PriceService implements CreatePriceUseCase, GetPriceUseCase {

    private final PriceOutputPort productOutputPort;

    @Override
    public Price createPrice(Price price) {
        price = productOutputPort.savePrice(price);        
        return price;
    }

    @Override
    public Price getPriceById(Long id) {
        return productOutputPort.getPriceById(id).orElseThrow(() -> new PriceNotFound("Price not found with id " + id));
    }

    @Override
    public Price getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return productOutputPort.getPrice(applicationDate, productId, brandId).orElseThrow(() -> new PriceNotFound("Price not found"));
    }

}
