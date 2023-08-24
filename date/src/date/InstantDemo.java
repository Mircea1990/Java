package date;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InstantDemo {

	public static void main(String[] args) {
		Instant instant1 = Instant.now();
		System.out.println("Instant1: " + instant1);

		Instant instant2 = Instant.now(Clock.systemUTC());
		System.out.println("Instant2: " + instant2);

		long now = System.currentTimeMillis();
		Instant instant3 = Instant.ofEpochMilli(now);
		System.out.println("Instant3: " + instant3);

		now = now / 1000;
		Instant instant4 = Instant.ofEpochMilli(now);
		System.out.println("Instance4: " + instant4);

		Instant instant5 = Instant.ofEpochSecond(now, 344500000);
		System.out.println("Instance5: " + instant5);

		Instant instant6 = Instant.parse("1990-03-26T11:18:35.08Z");
		System.out.println("Instance6: " + instant6);

		Instant instant7 = new Date().toInstant();
		System.out.println("Instance7: " + instant7);

		System.out.println("Convert instant to milliseconds: " + instant6.toEpochMilli());
		System.out.println("getEpochSecond(): " + instant1.getEpochSecond());
		System.out.println("getNano(): " + instant1.getNano());
		System.out.println("EpochSecond: " + instant1.getLong(ChronoField.INSTANT_SECONDS));
		System.out.println("Nano: " + instant1.get(ChronoField.NANO_OF_SECOND));

		addSubtractDemo();
		dateComparison();
		instantConversionExample();
	}

	private static void addSubtractDemo() {
		Instant instant = Instant.parse("1984-08-13T10:15:30.345Z");
		System.out.println("Instant: " + instant);

		// adding/subtracting seconds
		System.out.println("15 seconds before: " + instant.minusSeconds(15));
		System.out.println("10 seconds after: " + instant.plusSeconds(10));

		// adding/subtracting millis
		System.out.println("Minus 45000 millis: " + instant.minusMillis(45000));
		System.out.println("Plus 10000 millis: " + instant.minusMillis(10000));

		// adding/subtracting nanos
		System.out.println("Minus 5555 nanos: " + instant.minusNanos(5555));
		System.out.println("Plus 123456 nanos: " + instant.plusNanos(123456));

		// using MINUTES
		System.out.println("45 minutes before: " + instant.minus(45, ChronoUnit.MINUTES));

		// using HOURS
		System.out.println("3 hours before: " + instant.minus(3, ChronoUnit.HOURS));

		// using millis
		System.out.println("30000 millis later: " + instant.plus(30000, ChronoUnit.MILLIS));

		// using days
		System.out.println("10 days later: " + instant.plus(10, ChronoUnit.DAYS));

		// using TemporalAmount - Duration
		System.out.println("10 second before: " + instant.minus(Duration.ofSeconds(10)));

		// using TemporalAmount - Period
		System.out.println("5 days later: " + instant.plus(Period.ofDays(5)));
	}

	private static void dateComparison() {
		Instant instant1 = Instant.parse("1990-03-26T11:18:35.08Z");
		Instant instant2 = Instant.parse("1990-03-26T11:18:35.08Z");
		System.out.println("Instant1: " + instant1);
		System.out.println("Instant2: " + instant2);

		System.out.println("Instant1 after instant2: " + instant1.isAfter(instant2));
		System.out.println("Instant1 before instant2: " + instant1.isBefore(instant2));

		System.out.println("Instant1 compareTo instant2: " + instant1.compareTo(instant2));
		System.out.println("Instant2 compareTo instant1: " + instant2.compareTo(instant1));

		Calendar calendar1 = new GregorianCalendar(1013, 1, 28, 13, 24, 55);
		Calendar calendar2 = new GregorianCalendar(1013, 1, 28, 13, 24, 55);

		System.out.println("Calendar1 after calendar2: " + calendar1.after(calendar2));
		System.out.println("Calendar1 before calendar2: " + calendar1.before(calendar2));

		Date date1 = new Date(1090215021581L);
		Date date2 = new Date(1090215021581L);

		System.out.println("Date1 after date2: " + date1.after(date2));
		System.out.println("Date1 before date2: " + date1.before(date2));
	}

	private static void instantConversionExample() {
		Instant instant = Instant.parse("1990-03-26T11:18:35.08Z");

		LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		System.out.println("LocalDateTime: " + dateTime);

		ZonedDateTime zonedDateTime1 = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
		System.out.println("ZoneDateTime1: " + zonedDateTime1);

		ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("Asia/Tokyo"));
		System.out.println(zonedDateTime2);

		OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.UTC);
		System.out.println("OffsetDateTime: " + offsetDateTime);

	}

}
