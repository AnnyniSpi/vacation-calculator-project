package dev.annyni.vacationcalculatorproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.annyni.vacationcalculatorproject.VacationCalculatorProjectApplication;
import dev.annyni.vacationcalculatorproject.dto.VacationRequest;
import dev.annyni.vacationcalculatorproject.service.WeekendService;
import dev.annyni.vacationcalculatorproject.service.WeekendServiceImp;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * todo Document type VacationCalculatorControllerTest
 */
@RequiredArgsConstructor
@SpringBootTest(classes = VacationCalculatorProjectApplication.class)
public class VacationCalculatorControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WeekendService weekendService;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new VacationCalculatorController(new WeekendServiceImp())).build();
    }

    @Test
    public void testCalculateVacation() throws Exception {
        VacationRequest vacationRequest = new VacationRequest(150000.0, 15, LocalDate.of(2024, 6, 1), LocalDate.of(2024,6,15));
        long weekendsDays = weekendService.calculateWeekendsDays(vacationRequest.getStartVacation(), vacationRequest.getEndVacation());
        double result = (vacationRequest.getSalary() / 29.3) * (vacationRequest.getVacation() - weekendsDays);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/calculate")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(vacationRequest)))
            .andExpect(status().isOk())
            .andExpect(content().string("Vacation pay amount: " + Math.round(result)));

    }

}
