package com.prueba.inditex.infrastructure.adapters.input.rest.data.request;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.apache.tomcat.util.bcel.classfile.Constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prueba.inditex.infrastructure.adapters.Constants;

import io.swagger.v3.oas.annotations.media.Schema;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceCreateRequest { 
    private Long brand_id;//BRAND_ID 
    
    @Schema( description = "LocalDateTime of the accept, default to now if not provided",
    type = "string",
    example = Constants.FORMAT_TIMESTAND_EXAMPLE)
    @JsonFormat(pattern = Constants.FORMAT_TIMESTAND)
    private LocalDateTime start_date;//start_date

    @Schema( description = "LocalDateTime of the accept, default to now if not provided",
    type = "string",
    example = Constants.FORMAT_TIMESTAND_EXAMPLE)
    
    @JsonFormat(pattern = Constants.FORMAT_TIMESTAND)
    private LocalDateTime end_date;//end_date

    private Long price_list;//PRICE_LIST

    private Integer product_id;//PRODUCT_ID

    private Integer priority;//PRIORITY

    private Double price;//PRICE

    private String curr;//CURR

}

