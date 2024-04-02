package java8.ninethExercise;

import java.time.*;
import java.time.temporal.*;
import java.util.function.*;

public class DateTimeFunctions {

    // Predicate to check if the given date is yesterday's date
    static Predicate<LocalDate> isYesterday = date -> date.equals(LocalDate.now().minusDays(1));

    // Supplier to get the date for next Thursday
    static Supplier<LocalDate> nextThursday = () -> {
        LocalDate now = LocalDate.now();
        int daysUntilNextThursday = 3 - now.getDayOfWeek().getValue(); // 3 is Thursday in DayOfWeek enum
        return now.plusDays(daysUntilNextThursday);
    };

    // Supplier to get current time in EST timezone
    static Supplier<LocalTime> currentTimeInEST = () -> {
        return LocalTime.now(ZoneId.of("America/New_York"));
    };

    // Function to calculate age given date of birth
    static Function<LocalDate, Integer> calculateAge = dateOfBirth -> {
        LocalDate now = LocalDate.now();
        return Period.between(dateOfBirth, now).getYears();
    };

    public static void main(String[] args) {
        // Test Predicate to check if given date is yesterday's date
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate today = LocalDate.now();
        System.out.println("Is yesterday: " + isYesterday.test(yesterday)); // true
        System.out.println("Is yesterday: " + isYesterday.test(today)); // false

        // Test Supplier to get date for next Thursday
        System.out.println("Next Thursday: " + nextThursday.get());

        // Test Supplier to get current time in EST timezone
        System.out.println("Current time in EST: " + currentTimeInEST.get());

        // Test Function to calculate age
        LocalDate dateOfBirth = LocalDate.of(1990, 5, 15);
        System.out.println("Age: " + calculateAge.apply(dateOfBirth));
    }
}
