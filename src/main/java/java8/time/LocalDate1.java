package java8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class LocalDate1 {

	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		LocalDate amanha = hoje.plus(1, ChronoUnit.DAYS);
		LocalDate ontem = amanha.minusDays(2);

		System.out.println("Hoje: " + hoje);
		System.out.println("Amanhã: " + amanha);
		System.out.println("Ontem: " + ontem);

		LocalDate proclamacaoDaRepublica = LocalDate.of(1889, Month.NOVEMBER, 15);
		DayOfWeek diaDaSemana = proclamacaoDaRepublica.getDayOfWeek();
		System.out.println(diaDaSemana); // FRIDAY

		DateTimeFormatter germanFormatter = //
				DateTimeFormatter //
						.ofLocalizedDate(FormatStyle.MEDIUM) //
						.withLocale(Locale.GERMAN);

		LocalDate natal = LocalDate.parse("24.12.2014", germanFormatter);
		System.out.println(natal); // 2014-12-24

	}
}
