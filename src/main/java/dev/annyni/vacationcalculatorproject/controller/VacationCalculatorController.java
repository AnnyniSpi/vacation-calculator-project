package dev.annyni.vacationcalculatorproject.controller;

import dev.annyni.vacationcalculatorproject.dto.VacationRequest;
import dev.annyni.vacationcalculatorproject.service.WeekendService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * todo Document type VacationCalculatorController
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class VacationCalculatorController {

    private final WeekendService weekendService;

    @GetMapping("/calculate")
    public ResponseEntity<String> getCountDay(@RequestBody VacationRequest vacationRequest){
        long nonWorkingDays = weekendService.calculateWeekendsDays(vacationRequest.getStartVacation(), vacationRequest.getEndVacation());
        double result = vacationRequest.getSalary() / 29.3 * (vacationRequest.getVacation() - nonWorkingDays);

        return ResponseEntity.ok("Vacation pay amount: " + Math.round(result));
    }

}
