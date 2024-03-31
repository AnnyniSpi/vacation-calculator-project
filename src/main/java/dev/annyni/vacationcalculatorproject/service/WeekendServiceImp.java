package dev.annyni.vacationcalculatorproject.service;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * todo Document type WeekendServiceImp
 */
@Component
public class WeekendServiceImp implements WeekendService {
    private static final int CURRENT_YEAR = 2024;

    private final Set<LocalDate> weekends;

    public WeekendServiceImp() {
        weekends = Set.of(
            LocalDate.of(CURRENT_YEAR, 1, 1),
            LocalDate.of(CURRENT_YEAR, 1, 2),
            LocalDate.of(CURRENT_YEAR, 1, 3),
            LocalDate.of(CURRENT_YEAR, 1, 4),
            LocalDate.of(CURRENT_YEAR, 1, 5),
            LocalDate.of(CURRENT_YEAR, 1, 6),
            LocalDate.of(CURRENT_YEAR, 1, 8),
            LocalDate.of(CURRENT_YEAR, 2, 23),
            LocalDate.of(CURRENT_YEAR, 3, 8),
            LocalDate.of(CURRENT_YEAR, 5, 1),
            LocalDate.of(CURRENT_YEAR, 5, 9),
            LocalDate.of(CURRENT_YEAR, 6, 12),
            LocalDate.of(CURRENT_YEAR, 11, 4)
        );
    }

    public boolean isWeekend(LocalDate date) {
        return weekends.contains(date);
    }

    @Override
    public long calculateWeekendsDays(LocalDate startDate, LocalDate endDate) {
        long nonWorkingDays  = 0;

        LocalDate date = startDate;

        while (!date.isAfter(endDate)){
            if(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY){
                nonWorkingDays++;
            } else if(isWeekend(date)){
                nonWorkingDays++;
            }
            date = date.plusDays(1);
        }

        return nonWorkingDays;
    }
}
