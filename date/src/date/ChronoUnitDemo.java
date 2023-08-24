package date;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ChronoUnitDemo {

	public static void main(String[] args) {
		LocalDateTime oldDate = LocalDateTime.of(1990, Month.MARCH, 26, 10, 20, 55);
		LocalDateTime newDate = LocalDateTime.of(2023, Month.SEPTEMBER, 23, 19, 20, 55);

		System.out.println(oldDate);
		System.out.println(newDate);

		// count dates
		long years = ChronoUnit.YEARS.between(oldDate, newDate);
		long months = ChronoUnit.MONTHS.between(oldDate, newDate);
		long weeks = ChronoUnit.WEEKS.between(oldDate, newDate);
		long days = ChronoUnit.DAYS.between(oldDate, newDate);
		long hours = ChronoUnit.HOURS.between(oldDate, newDate);
		long minutes = ChronoUnit.MINUTES.between(oldDate, newDate);
		long seconds = ChronoUnit.SECONDS.between(oldDate, newDate);
		long mili = ChronoUnit.MILLIS.between(oldDate, newDate);
		long nano = ChronoUnit.NANOS.between(oldDate, newDate);

		System.out.println("Years: " + years + " Months: " + months + " Weekes: " + weeks + " Days: " + days);
	}

}
