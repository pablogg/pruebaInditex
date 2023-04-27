package com.prueba.inditex.infrastructure.adapters.output.persistence.entity;

import lombok.*;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceEntity {

    
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brand_id;//BRAND_ID         
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime  start_date;//start_LocalDateTime    
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime  end_date;//end_date
    @Id
    private Long price_list;//PRICE_LIST
    private Integer product_id;//PRODUCT_ID
    private Integer priority;//PRIORITY
    private Double price;//PRICE
    private String curr;//CURR
}


