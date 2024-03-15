package com.stepanew.neoflextask;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.closeTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@ActiveProfiles("test")
public class CalculatorControllerTest extends BaseControllerTest {

    @Test
    public void testCalculateCorrectVacation() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/v1/calculate")
                                .param("Average salary", "100000")
                                .param("Vacation days", "14"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.totalVacationPay").value(closeTo(Double.parseDouble("47781.56996587031"), 0.001)));
    }

    @Test
    public void testIncorrectNegativeAverageSalary() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/v1/calculate")
                                .param("Average salary", "-100000")
                                .param("Vacation days", "14"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testIncorrectNonDoubleAverageSalary() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/v1/calculate")
                                .param("Average salary", "averageSalary")
                                .param("Vacation days", "14"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testIncorrectNegativeVacationDays() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/v1/calculate")
                                .param("Average salary", "100000")
                                .param("Vacation days", "-14"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testIncorrectNonDoubleVacationDays() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/v1/calculate")
                                .param("Average salary", "10000")
                                .param("Vacation days", "Vacation days"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
