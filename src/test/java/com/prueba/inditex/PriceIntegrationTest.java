package com.prueba.inditex;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.prueba.inditex.domain.model.Price;
import com.prueba.inditex.infrastructure.adapters.Constants;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

  private static ObjectMapper mapper= JsonMapper.builder()
  .addModule(new JavaTimeModule())
  .build();

  @BeforeEach
	public void testaCreatePrices() throws Exception {
    this.mockMvc.perform(post("/v1/price")
      .contentType(MediaType.APPLICATION_JSON)
      .content(mapper.writeValueAsString(createPrice1()))
      .characterEncoding("utf-8"))
      .andExpect(status().isCreated())
      .andReturn();

      this.mockMvc.perform(post("/v1/price")
      .contentType(MediaType.APPLICATION_JSON)
      .content(mapper.writeValueAsString(createPrice2()))
      .characterEncoding("utf-8"))
      .andExpect(status().isCreated())
      .andReturn();

      this.mockMvc.perform(post("/v1/price")
      .contentType(MediaType.APPLICATION_JSON)
      .content(mapper.writeValueAsString(createPrice3()))
      .characterEncoding("utf-8"))
      .andExpect(status().isCreated())
      .andReturn();

      this.mockMvc.perform(post("/v1/price")
      .contentType(MediaType.APPLICATION_JSON)
      .content(mapper.writeValueAsString(createPrice4()))
      .characterEncoding("utf-8"))
      .andExpect(status().isCreated())
      .andReturn();
  }
      
  
  @Test
	public void test1() throws Exception {    
    this.mockMvc.perform(get("/v1/price")        
      .param("applicationDate","2020-06-14-10.00.00")
      .param("productId","35455")
      .param("brandId","1"))
    //.andDo(print())
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.price", Matchers.equalTo(35.50)))
    .andExpect(jsonPath("$.price_list", Matchers.equalTo(1)));    

  }
  @Test
  public void test2() throws Exception {   
    this.mockMvc.perform(get("/v1/price")        
      .param("applicationDate","2020-06-14-16.00.00")
      .param("productId","35455")
      .param("brandId","1"))
    //.andDo(print())
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.price", Matchers.equalTo(25.45)))
    .andExpect(jsonPath("$.price_list", Matchers.equalTo(2)));    

	
  }
  @Test
  public void test3() throws Exception {   
    this.mockMvc.perform(get("/v1/price")        
      .param("applicationDate","2020-06-14-21.00.00")
      .param("productId","35455")
      .param("brandId","1"))
    //.andDo(print())
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.price", Matchers.equalTo(35.50)))
    .andExpect(jsonPath("$.price_list", Matchers.equalTo(1)));    
  
  }
  @Test
  public void test4() throws Exception {
    this.mockMvc.perform(get("/v1/price")        
      .param("applicationDate","2020-06-15-10.00.00")
      .param("productId","35455")
      .param("brandId","1"))
    //.andDo(print())
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.price", Matchers.equalTo(30.50)))
    .andExpect(jsonPath("$.price_list", Matchers.equalTo(3)));    
    
  }
  @Test
  public void test5() throws Exception {
    this.mockMvc.perform(get("/v1/price")        
      .param("applicationDate","2020-06-16-21.00.00")
      .param("productId","35455")
      .param("brandId","1"))
    //.andDo(print())
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.price", Matchers.equalTo(38.95)))
    .andExpect(jsonPath("$.price_list", Matchers.equalTo(4)));    
	}

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.FORMAT_TIMESTAND);
  private Price createPrice1() {
    Price price = new Price();
    price.setBrand_id(Long.valueOf(1));
    price.setStart_date(LocalDateTime.from(formatter.parse("2020-06-14-00.00.00")));
    price.setEnd_date(LocalDateTime.from(formatter.parse("2020-12-31-23.59.59")));
    price.setPrice_list(Long.valueOf(1));
    price.setProduct_id(35455);
    price.setPriority(0);
    price.setPrice(35.50);
    price.setCurr("EUR");
    return price;
  }
  private Price createPrice2() {
    Price price = new Price();
    price.setBrand_id(Long.valueOf(1));
    price.setStart_date(LocalDateTime.from(formatter.parse("2020-06-14-15.00.00")));
    price.setEnd_date(LocalDateTime.from(formatter.parse("2020-06-14-18.30.00")));
    price.setPrice_list(Long.valueOf(2));
    price.setProduct_id(35455);
    price.setPriority(1);
    price.setPrice(25.45);
    price.setCurr("EUR");
    return price;
  }
  private Price createPrice3() {
    Price price = new Price();
    price.setBrand_id(Long.valueOf(1));
    price.setStart_date(LocalDateTime.from(formatter.parse("2020-06-15-00.00.00")));
    price.setEnd_date(LocalDateTime.from(formatter.parse("2020-06-15-11.00.00")));
    price.setPrice_list(Long.valueOf(3));
    price.setProduct_id(35455);
    price.setPriority(1);
    price.setPrice(30.50);
    price.setCurr("EUR");
    return price;
  }
  private Price createPrice4() {
    Price price = new Price();
    price.setBrand_id(Long.valueOf(1));
    price.setStart_date(LocalDateTime.from(formatter.parse("2020-06-15-16.00.00")));
    price.setEnd_date(LocalDateTime.from(formatter.parse("2020-12-31-23.59.59")));
    price.setPrice_list(Long.valueOf(4));
    price.setProduct_id(35455);
    price.setPriority(1);
    price.setPrice(38.95);
    price.setCurr("EUR");
    return price;
  }
}
   
 
  
