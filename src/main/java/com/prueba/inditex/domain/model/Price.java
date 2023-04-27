package com.prueba.inditex.domain.model;




import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Price {  

    private Long brand_id;//BRAND_ID         
    private LocalDateTime  start_date;//start_date
    private LocalDateTime  end_date;//end_date
    private Long price_list;//PRICE_LIST
    private Integer product_id;//PRODUCT_ID
    private Integer priority;//PRIORITY
    private Double price;//PRICE
    private String curr;//CURR
}
