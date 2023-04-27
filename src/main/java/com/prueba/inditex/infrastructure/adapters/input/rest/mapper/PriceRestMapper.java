package com.prueba.inditex.infrastructure.adapters.input.rest.mapper;

import com.prueba.inditex.domain.model.Price;
import com.prueba.inditex.infrastructure.adapters.input.rest.data.response.PriceQueryResponse;
import com.prueba.inditex.infrastructure.adapters.input.rest.data.request.PriceCreateRequest;
import com.prueba.inditex.infrastructure.adapters.input.rest.data.response.PriceCreateResponse;
import org.mapstruct.Mapper;

@Mapper
public interface PriceRestMapper {

    Price toPrice(PriceCreateRequest priceCreateRequest);

    PriceCreateResponse toPriceCreateResponse(Price price);

    PriceQueryResponse toPriceQueryResponse(Price price);

}
