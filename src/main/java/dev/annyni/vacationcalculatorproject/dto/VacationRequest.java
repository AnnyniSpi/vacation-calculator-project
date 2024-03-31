package dev.annyni.vacationcalculatorproject.dto;

import java.time.LocalDate;

/**
 * todo Document type VacationRequest
 */
public class VacationRequest {
    private final double salary;
    private final int vacation;
    private final LocalDate startVacation;
    private final LocalDate endVacation;

    public VacationRequest(double salary, int vacation, LocalDate startVacation, LocalDate endVacation) {
        this.salary = salary;
        this.vacation = vacation;
        this.startVacation = startVacation;
        this.endVacation = endVacation;
    }

    public double getSalary() {
        return salary;
    }

    public int getVacation() {
        return vacation;
    }

    public LocalDate getStartVacation() {
        return startVacation;
    }

    public LocalDate getEndVacation() {
        return endVacation;
    }
}
