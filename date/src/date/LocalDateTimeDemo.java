package date;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeDemo {

	public static void main(String[] args) {
		localDateTimeInstantiationExample();
		gettingInformationExample();
		addSubtractTimeExample();
	}

	private static void addSubtractTimeExample() {
		LocalDateTime localDateTime = LocalDateTime.parse("1981-10-18T10:20:45");
		System.out.println("LocalDateTime: " + localDateTime);

		// adding/subtracting days
		System.out.println("10 days before: " + localDateTime.minusDays(10));
		System.out.println("15 days later: " + localDateTime.plusDays(15));

		// adding / subtracting months
		System.out.println("Minus 4 months: " + localDateTime.minusMonths(4));
		System.out.println("Plus 5 months: " + localDateTime.plusMonths(5));

		// adding / subtracting weeks
		System.out.println("Minus 20 weeks: " + localDateTime.minusWeeks(20));
		System.out.println("Plus 30 weeks: " + localDateTime.plusWeeks(30));

		// adding / subtracting years
		System.out.println("Minus 12 years: " + localDateTime.minusYears(12));
		System.out.println("Plus 4 years: " + localDateTime.plusYears(4));

		// adding / subtracting hours
		System.out.println("12 hours before: " + localDateTime.minusHours(12));
		System.out.println("6 hours later: " + localDateTime.plusHours(6));

		// adding / subtracting minutes
		System.out.println("Minus 40 minutes: " + localDateTime.minusMinutes(40));
		System.out.println("Plus 15 minutes: " + localDateTime.plusMinutes(15));

		// adding / subtracting seconds
		System.out.println("Minus 30 seconds: " + localDateTime.minusSeconds(30));
		System.out.println("Plus 20 seconds: " + localDateTime.plusSeconds(20));

		// adding / subtracting nanos
		System.out.println("Minus 20000 nonos: " + localDateTime.minusNanos(20000));
		System.out.println("Plus 340000 nanos: " + localDateTime.plusNanos(340000));

		// Using DAYS
		System.out.println("30 days before      : " + localDateTime.minus(30, ChronoUnit.DAYS));
		// Using WEEKS
		System.out.println("3 weeks before      : " + localDateTime.minus(3, ChronoUnit.WEEKS));
		// Using MONTHS
		System.out.println("6 months later      : " + localDateTime.plus(6, ChronoUnit.MONTHS));
		// Using YEARS
		System.out.println("2 years later       : " + localDateTime.plus(2, ChronoUnit.YEARS));

		// Using HOURS
		System.out.println("8 hours before      : " + localDateTime.minus(8, ChronoUnit.HOURS));
		// Using MINUTES
		System.out.println("35 minutes before   : " + localDateTime.minus(35, ChronoUnit.MINUTES));
		// Using SECONDS
		System.out.println("125 seconds later   : " + localDateTime.plus(125, ChronoUnit.SECONDS));
		// Using NANOS
		System.out.println("42357500 nanos later: " + localDateTime.plus(42357500, ChronoUnit.NANOS));

		// Using TemporalAmount - Period
		System.out.println("5 years later       : " + localDateTime.plus(Period.ofYears(5)));
		// Using TemporalAmount - Duration
		System.out.println("60 days before      : " + localDateTime.minus(Duration.ofDays(60)));
		System.out.println("160 minutes before  : " + localDateTime.minus(Duration.ofMinutes(160)));
		System.out.println("2 hours later       : " + localDateTime.plus(Duration.ofHours(2)));
	}

	private static void gettingInformationExample() {
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("LocalDateTime   : " + dateTime);
		System.out.println("DayOfMonth      : " + dateTime.getDayOfMonth());
		System.out.println("MonthValue      : " + dateTime.getMonthValue());
		System.out.println("Year            : " + dateTime.getYear());

		System.out.println("Hour            : " + dateTime.getHour());
		System.out.println("Minute          : " + dateTime.getMinute());
		System.out.println("Second          : " + dateTime.getSecond());
		System.out.println("Nano            : " + dateTime.getNano());

		System.out.println("DayOfWeek       : " + dateTime.getDayOfWeek());
		System.out.println("Month           : " + dateTime.getMonth());
		System.out.println("DayOfYear       : " + dateTime.getDayOfYear());

		System.out.println("DAY_OF_MONTH    : " + dateTime.get(ChronoField.DAY_OF_MONTH));
		System.out.println("MONTH_OF_YEAR   : " + dateTime.get(ChronoField.MONTH_OF_YEAR));
		System.out.println("YEAR            : " + dateTime.get(ChronoField.YEAR));

		System.out.println("HOUR_OF_DAY     : " + dateTime.get(ChronoField.HOUR_OF_DAY));
		System.out.println("MINUTE_OF_HOUR  : " + dateTime.get(ChronoField.MINUTE_OF_HOUR));
		System.out.println("SECOND_OF_MINUTE: " + dateTime.get(ChronoField.SECOND_OF_MINUTE));

		System.out.println("MINUTE_OF_DAY   : " + dateTime.getLong(ChronoField.MINUTE_OF_DAY));
		System.out.println("SECOND_OF_DAY   : " + dateTime.getLong(ChronoField.SECOND_OF_DAY));

		System.out.println("Chronology      : " + dateTime.getChronology());

		System.out.println("toEpochSecond() : " + dateTime.toEpochSecond(ZoneOffset.UTC));

	}

	private static void localDateTimeInstantiationExample() {
		LocalDateTime dateTime1 = LocalDateTime.now();
		System.out.println("LocalDateTime1: " + dateTime1);

		LocalDateTime dateTime2 = LocalDateTime.now(Clock.systemUTC());
		System.out.println("LocalDateTime2 : " + dateTime2);

		LocalDateTime dateTime3 = LocalDateTime.now(ZoneId.systemDefault());
		System.out.println("LocalDateTime3 : " + dateTime3);

		LocalDateTime dateTime4 = LocalDateTime.of(1980, 4, 9, 20, 15);
		System.out.println("LocalDateTime4 : " + dateTime4);

		LocalDateTime dateTime6 = LocalDateTime.of(1979, 12, 9, 18, 5, 50);
		System.out.println("LocalDateTime6 : " + dateTime6);

		LocalDateTime dateTime8 = LocalDateTime.of(1983, 7, 12, 20, 15, 50, 345678900);
		System.out.println("LocalDateTime8 : " + dateTime8);

		LocalDateTime dateTime10 = LocalDateTime.of(LocalDate.now(), LocalTime.of(15, 50));
		System.out.println("LocalDateTime10: " + dateTime10);

		LocalDateTime dateTime11 = LocalDateTime.ofEpochSecond(1555552018, 456789500, ZoneOffset.UTC);
		System.out.println("LocalDateTime11: " + dateTime11);

		LocalDateTime dateTime12 = LocalDateTime.ofInstant(Instant.ofEpochMilli(324142255123L), ZoneId.systemDefault());
		System.out.println("LocalDateTime12: " + dateTime12);

		LocalDateTime dateTime13 = LocalDateTime.parse("1945-08-17T10:20:45");
		System.out.println("LocalDateTime13: " + dateTime13);

		LocalDateTime dateTime14 = LocalDateTime.parse("20190824155025", DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		System.out.println("LocalDateTime14: " + dateTime14);
	}

}
