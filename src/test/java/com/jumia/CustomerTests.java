package com.jumia;

import com.jumia.controllers.CustomerController;
import com.jumia.repos.CustomerRepo;
import com.jumia.repos.CustomerViewRepo;
import com.jumia.services.ICustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerTests extends JumiaProgrammingExerciseApplicationTests {

  @Autowired private CustomerController customerController;
  @Autowired private CustomerRepo customerRepo;
  @Autowired private CustomerViewRepo customerViewRepo;
  @Autowired private ICustomerService customerService;

  @Test
  @DisplayName("Ensure that customer controller is available in the bean pool")
  @Order(1)
  public void customerControllerTest() {
    assertThat(customerController).isNotNull();
  }

  @Test
  @DisplayName("Ensure that customer  repo is available in the bean pool")
  @Order(2)
  public void customerRepoTest() {
    assertThat(customerRepo).isNotNull();
  }

  @Test
  @DisplayName("Ensure that customer view repo is available in the bean pool")
  @Order(3)
  public void customerViewRepoTest() {
    assertThat(customerViewRepo).isNotNull();
  }

  @Test
  @DisplayName("Ensure that customer service is available in the bean pool")
  @Order(4)
  public void customerServiceTest() {
    assertThat(customerService).isNotNull();
  }

  @Test
  @DisplayName("Get paginated response - no filters - default pageable")
  @Order(5)
  public void getPaginatedResponse() throws Exception {
    this.mockMvc
        .perform(get("/customer"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$", hasSize(10)));
  }

  @Test
  @DisplayName("Get paginated response - page and size specified")
  @Order(6)
  public void getPaginatedResponseWithPageAndSize() throws Exception {
    this.mockMvc
        .perform(get("/customer").param("page", "1").param("size", "5"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$", hasSize(5)));
  }

  @Test
  @DisplayName("Get all customers - no filters")
  @Order(7)
  public void getAllCustomers() throws Exception {
    this.mockMvc
        .perform(get("/customer/get-all"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$", hasSize(41)));
  }

  @Test
  @DisplayName("Get all customers - filtered by country")
  @Order(8)
  public void getAllCustomersFilteredByCountry() throws Exception {
    this.mockMvc
        .perform(get("/customer/get-all").queryParam("country", "Cameroon"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$", hasSize(10)));
  }

  @Test
  @DisplayName("Get all customers - filtered by state")
  @Order(9)
  public void getAllCustomersFilteredByState() throws Exception {
    this.mockMvc
        .perform(get("/customer/get-all").queryParam("state", "true"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$", hasSize(27)));
  }

  @Test
  @DisplayName("Get all customers - filtered by country & state")
  @Order(10)
  public void getAllCustomersFilteredByCountryAndState() throws Exception {
    this.mockMvc
        .perform(
            get("/customer/get-all").queryParam("country", "Cameroon").queryParam("state", "true"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$", hasSize(7)));
  }
}
