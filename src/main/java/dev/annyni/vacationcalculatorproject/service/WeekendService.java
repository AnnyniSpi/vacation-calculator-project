package dev.annyni.vacationcalculatorproject.service;

import java.time.LocalDate;

/**
 * todo Document type WeekendService
 */
public interface WeekendService {

    long calculateWeekendsDays(LocalDate startDate, LocalDate endDate);
}
