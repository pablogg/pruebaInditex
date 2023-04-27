package com.prueba.inditex.application.ports.output;

import java.time.LocalDateTime;
import java.util.Optional;

import com.prueba.inditex.domain.model.Price;

public interface PriceOutputPort {

    Price savePrice(Price price);

    Optional<Price> getPriceById(Long id);

    Optional<Price> getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId);

}
