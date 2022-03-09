package java8.time;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class LocalTime1 {

	public static void main(String[] args) {

		Clock clock = Clock.systemDefaultZone();
		long t0 = clock.millis();
		System.out.println(t0);

		Instant instante = clock.instant();
		Date dataAntiga = Date.from(instante);

		ZoneId zona1 = ZoneId.of("Europe/Berlin");
		ZoneId zona2 = ZoneId.of("Brazil/East");

		System.out.println("Zona Europe/Berlin: " + zona1.getRules());
		System.out.println("Zona Brazil/East: " + zona2.getRules());

		// Time
		LocalTime agora1 = LocalTime.now(zona1);
		LocalTime agora2 = LocalTime.now(zona2);

		System.out.println("Horário local Berlin: " + agora1);
		System.out.println("Horário local Brasil: " + agora2);

		System.out.println(agora1.isBefore(agora2)); // false

		long horasEntre = ChronoUnit.HOURS.between(agora1, agora2);
		long minutosEntre = ChronoUnit.MINUTES.between(agora1, agora2);

		System.out.println("Horas entre Brasil e Berlin: " + horasEntre);
		System.out.println("Minutos entre Brasil e Berlin: " + minutosEntre);

		// Create Time
		LocalTime agora = LocalTime.now();
		System.out.println("LocalTime.now() = " + agora);

		LocalTime noite = LocalTime.of(23, 59, 59);
		System.out.println("LocalTime.of(23, 59, 59) = " + noite);

		DateTimeFormatter formatter = //
				DateTimeFormatter //
						.ofLocalizedTime(FormatStyle.SHORT) //
						.withLocale(Locale.GERMAN);

		LocalTime tempo = LocalTime.parse("13:37", formatter);
		System.out.println(tempo);

	}
}
