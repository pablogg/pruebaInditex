package com.prueba.inditex.application.ports.input;



import java.time.LocalDateTime;

import com.prueba.inditex.domain.model.Price;

public interface GetPriceUseCase {

    Price getPriceById(Long id);

    Price getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId);

}
