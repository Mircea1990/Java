package date;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public class ClockDemo {

	public static void main(String[] args) {
		Clock clock = Clock.systemDefaultZone();
		Instant instant = clock.instant();
		System.out.println(instant);

		Clock clock2 = Clock.systemUTC();
		System.out.println("UTC time: " + clock2);

		Clock clock3 = Clock.system(ZoneId.of("Europe/Bucharest"));
		System.out.println(clock3.instant());

		Clock clock4 = Clock.systemDefaultZone();
		System.out.println(clock4);
		System.out.println(clock4.millis());

		Clock clock5 = Clock.system(ZoneId.systemDefault());
		System.out.println(clock5);

		Clock fixedClock = Clock.fixed(Instant.parse("2023-08-23T16:53:58.769347200Z"), ZoneId.of("Europe/Bucharest"));
		System.out.println(fixedClock);

		Clock baseClock = Clock.systemDefaultZone();

		// result clock will be later than baseClock
		Clock clock6 = Clock.offset(baseClock, Duration.ofHours(72));
		System.out.println(clock6.instant());

		// result clock will be same as baseClock
		clock6 = Clock.offset(baseClock, Duration.ZERO);
		System.out.println(clock6.instant());

		// result clock will be earlier than baseClock
		clock6 = Clock.offset(baseClock, Duration.ofHours(-72));
		System.out.println(clock6.instant());
	}

}
