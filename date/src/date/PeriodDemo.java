package date;

import java.time.LocalDate;
import java.time.Period;

public class PeriodDemo {

	public static void main(String[] args) {
		LocalDate startDate = LocalDate.of(1995, 4, 11);
		LocalDate endDate = LocalDate.of(2000, 3, 18);

		Period period = Period.between(startDate, endDate);
		System.out.println("Period years: " + period.getYears() + ", months: " + period.getMonths() + ", days: "
				+ period.getDays());

		Period fromUnits = Period.of(3, 10, 10);
		System.out.println("From units: " + fromUnits);
		Period fromDays = Period.ofDays(50);
		System.out.println("From days: " + fromDays);
		Period fromMonths = Period.ofMonths(5);
		System.out.println("From months: " + fromMonths);
		Period fromYears = Period.ofYears(10);
		System.out.println("From years: " + fromYears);
		Period fromWeeks = Period.ofWeeks(40);
		System.out.println("From weeks: " + fromWeeks);

		Period years = Period.parse("P5Y");
		System.out.println("years: " + years.getYears());

		Period days = Period.parse("P5Y2M10D");
		System.out.println("days: " + days.getDays());

	}

}
