package com.prueba.inditex.application.ports.input;

import com.prueba.inditex.domain.model.Price;

public interface CreatePriceUseCase {

    Price createPrice(Price price);

}
