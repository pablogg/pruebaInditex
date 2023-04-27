package com.prueba.inditex.infrastructure.adapters.input.rest;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Timestamp;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prueba.inditex.application.ports.input.CreatePriceUseCase;
import com.prueba.inditex.application.ports.input.GetPriceUseCase;
import com.prueba.inditex.domain.model.Price;
import com.prueba.inditex.infrastructure.adapters.Constants;
import com.prueba.inditex.infrastructure.adapters.input.rest.data.request.PriceCreateRequest;
import com.prueba.inditex.infrastructure.adapters.input.rest.data.response.PriceCreateResponse;
import com.prueba.inditex.infrastructure.adapters.input.rest.data.response.PriceQueryResponse;
import com.prueba.inditex.infrastructure.adapters.input.rest.mapper.PriceRestMapper;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class PriceRestAdapter {

    private final CreatePriceUseCase createPriceUseCase;

    private final GetPriceUseCase getPriceUseCase;

    private final PriceRestMapper priceRestMapper;

    @PostMapping(value = "/price")
    public ResponseEntity<PriceCreateResponse> createPrice(@RequestBody @Valid PriceCreateRequest priceCreateRequest){
        // Request to domain
        Price price = priceRestMapper.toPrice(priceCreateRequest);

        price = createPriceUseCase.createPrice(price);

        // Domain to response
        return new ResponseEntity<>(priceRestMapper.toPriceCreateResponse(price), HttpStatus.CREATED);
    }
   
    @GetMapping(value = "/price")
    public ResponseEntity<PriceQueryResponse> getPrice(  
        @RequestParam(value = "applicationDate", required = false)
        String applicationDate,        
        @RequestParam(value = "productId", required = false) Integer productId,
        @RequestParam(value = "brandId", required = false) Integer brandId){
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.FORMAT_TIMESTAND);
        LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(applicationDate));
        Price price = getPriceUseCase.getPrice(localDateTime,productId,brandId);
        return new ResponseEntity<>(priceRestMapper.toPriceQueryResponse(price), HttpStatus.OK);
    }
   

}

