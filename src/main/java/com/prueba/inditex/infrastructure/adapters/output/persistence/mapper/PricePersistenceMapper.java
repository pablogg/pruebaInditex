package com.prueba.inditex.infrastructure.adapters.output.persistence.mapper;

import com.prueba.inditex.domain.model.Price;
import com.prueba.inditex.infrastructure.adapters.output.persistence.entity.PriceEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PricePersistenceMapper {

    PriceEntity toPriceEntity(Price price);

    Price toPrice(PriceEntity productEntity);

}
