package com.jumia;

import com.jumia.controllers.CustomerController;
import com.jumia.services.ICustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerTests extends JumiaProgrammingExerciseApplicationTests {

  @Autowired private CustomerController customerController;
  @Autowired private ICustomerService customerService;

  @Test
  @DisplayName("Ensure that customer controller is available in the bean pool")
  @Order(1)
  public void customerControllerTest() {
    assertThat(customerController).isNotNull();
  }

  @Test
  @DisplayName("Ensure that customer service is available in the bean pool")
  @Order(2)
  public void customerServiceTest() {
    assertThat(customerService).isNotNull();
  }

  @Test
  @DisplayName("Get paginated response - no filters - default pageable")
  @Order(3)
  public void getPaginatedResponse() throws Exception {
    this.mockMvc
        .perform(get("/customer"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.content").isArray())
        .andExpect(jsonPath("$.content", hasSize(10)))
        .andExpect(jsonPath("$.pageable.pageNumber", is(0)));
  }

  @Test
  @DisplayName("Get paginated response - page and size specified")
  @Order(4)
  public void getPaginatedResponseWithPageAndSize() throws Exception {
    this.mockMvc
        .perform(get("/customer").param("page", "1").param("size", "5"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.content").isArray())
        .andExpect(jsonPath("$.content", hasSize(5)))
        .andExpect(jsonPath("$.pageable.pageNumber", is(1)));
  }

  @Test
  @DisplayName("Get all customers")
  @Order(5)
  public void getAllCustomers() throws Exception {
    this.mockMvc
        .perform(get("/customer/get-all"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$", hasSize(41)));
  }
}
