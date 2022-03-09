package java8.time;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

public class LocalDateTime1 {

	public static void main(String[] args) {
		LocalDateTime abolicao = LocalDateTime.of(1889, Month.MAY, 13, 12, 15, 35);

		DayOfWeek diaDaSemana = abolicao.getDayOfWeek();
		System.out.println("Dia da semana da aboloção: " + diaDaSemana); // MONDAY

		Month mes = abolicao.getMonth();
		System.out.println("Mês da abolição: " + mes); // MAY

		long minutoDoDia = abolicao.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println("Minuto do dia: " + minutoDoDia); // 735

		Instant instante = abolicao //
				.atZone(ZoneId.systemDefault()) //
				.toInstant();
		Date dataAntiga = Date.from(instante);
		System.out.println("Data antiga: " + dataAntiga); // Mon May 13 12:22:03 BRT 1889

		DateTimeFormatter formatter = //
				DateTimeFormatter //
						.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime parse = LocalDateTime.parse("13/05/1989 17:35", formatter);
		String convertida = parse.format(formatter);
		System.out.println(convertida); // 13/05/1989 17:35

	}
}
