package com.prueba.inditex;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.prueba.inditex.domain.model.Price;
import com.prueba.inditex.domain.service.PriceService;
import com.prueba.inditex.infrastructure.adapters.Constants;
import com.prueba.inditex.infrastructure.adapters.output.persistence.PricePersistenceAdapter;

public class PricePersistenceAdapterUnitTest {
	
	 @InjectMocks
	 private PriceService priceService;

	 @Mock
	 private PricePersistenceAdapter pricePersistenceAdapter;
	 

	 private Price price = new Price();

	 private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.FORMAT_TIMESTAND);

	 @BeforeEach
	 void setUp(){
	        MockitoAnnotations.initMocks(this);		
	        
	        price.setBrand_id(Long.valueOf(1));
	        price.setStart_date(LocalDateTime.from(formatter.parse("2020-06-14-00.00.00")));
	        price.setEnd_date(LocalDateTime.from(formatter.parse("2020-12-31-23.59.59")));
	        price.setPrice_list(Long.valueOf(1));
	        price.setProduct_id(35455);
	        price.setPriority(0);
	        price.setPrice(35.50);
	        price.setCurr("EUR");	         
   	}    
	 
	@Test
	void getPrice() {		 		
		when(pricePersistenceAdapter.getPrice(LocalDateTime.from(formatter.parse("2020-06-14-00.00.00")), 35455,1)).thenReturn(Optional.of(price));
	}
	
	@Test
	void savePrice() {
		when(pricePersistenceAdapter.savePrice(price)).thenReturn(price);		
	}
	
}
