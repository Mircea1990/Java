package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class Demo {

	public static void main(String[] args) throws ParseException {
		calendarExample();

		System.out.println("================================");

		simpleDateFormatExample();

		System.out.println("================================");

		dateExample();
		System.out.println("================================");

		timeZoneExample();
		System.out.println("================================");

		zoneIdExample();
		System.out.println("================================");

		convertDateCalendar();
	}

	private static void convertDateCalendar() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "23-08-2023 20:00:50";
		Date date = sdf.parse(dateInString);
		System.out.println("Date: " + date);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		date = calendar.getTime();
		System.out.println("Date converted from Calendar: " + date);
	}

	private static void zoneIdExample() {
		ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
	}

	private static void timeZoneExample() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");
		sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		Date date = new Date(65431537869L);
		System.out.println(sdf.format(date));

		sdf.setTimeZone(TimeZone.getTimeZone(ZoneId.of("+1")));
		System.out.println(sdf.format(date));
	}

	private static void dateExample() throws ParseException {
		Date date = new Date(1990, 3, 7);
		Date date2 = new Date();
		Date date3 = new Date(4645134348768L);

		System.out.println(date3);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		Date dateParsed = sdf.parse("1999/01/10 10:02:02");
		System.out.println(dateParsed);

		String dateString = sdf.format(dateParsed);
		System.out.println(dateString);
	}

	private static void simpleDateFormatExample() {
		Calendar calendar = new GregorianCalendar(1013, 1, 28, 13, 24, 56);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		System.out.println(simpleDateFormat.format(calendar.getTime()));

		simpleDateFormat = new SimpleDateFormat("yyyy MMM dd HH:mm:ss", Locale.ENGLISH);
		System.out.println(simpleDateFormat.format(calendar.getTime()));

		simpleDateFormat = new SimpleDateFormat("yy M dd HH:mm:ss", Locale.US);
		System.out.println(simpleDateFormat.format(calendar.getTime()));
	}

	private static void calendarExample() {
		Calendar calendar = new GregorianCalendar(1990, 03, 26, 13, 24, 56);

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);

		int hour = calendar.get(Calendar.HOUR);
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int milisecond = calendar.get(Calendar.MILLISECOND);

		System.out.println("Year: " + year);
		System.out.println("Month: " + month);
		System.out.println("Day Of Month: " + dayOfMonth);
		System.out.println("Day Of Week: " + dayOfWeek);
		System.out.println("Week Of Year: " + weekOfYear);
		System.out.println("Week Of Month: " + weekOfMonth);

		System.out.println("Hour: " + hour);
		System.out.println("Hour Of Day: " + hourOfDay);
		System.out.println("Minute: " + minute);
		System.out.println("Second: " + second);
		System.out.println("Milisecond: " + milisecond);
	}

}
