import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateAPI {


    public static void main(String[] args) {
        //Clock
        System.out.println("clock =================");
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);

        //Timezones
        System.out.println("timezones =============");
        System.out.println(ZoneId.getAvailableZoneIds());
        //prints all available timezone ids

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        //LocalTime
        System.out.println("local time ===========");
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println(now1.isBefore(now2));//false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minuteBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween);
        System.out.println(minuteBetween);

        //parsing of time strings(local time)
        LocalTime late = LocalTime.of(23,59,59);
        System.out.println(late); //23:59:59

        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                    .ofLocalizedDate(FormatStyle.SHORT)
                    .withLocale(Locale.GERMAN);
            //here something doesn't work
//        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
//        System.out.println(leetTime);

        //LocaDate
        System.out.println("local date ===============");
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);

        DateTimeFormatter germanFormatter2 =
                DateTimeFormatter
                    .ofLocalizedDate(FormatStyle.MEDIUM)
                    .withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter2);
        System.out.println(xmas);

        //LocalDate Time
        System.out.println("local data time ==============");
        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31,23,59,59);

        DayOfWeek dayOfWeek1 = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek1);

        Month month = sylvester.getMonth();
        System.out.println(month);

        long minuteOfDay = sylvester.getLong(ChronoField.MICRO_OF_DAY);
        System.out.println(minuteOfDay);

        //Instants
        Instant instant1 = sylvester
                .atZone( ZoneId.systemDefault())
                .toInstant();

        Date legacyDate2 = Date.from(instant1);
        System.out.println(legacyDate2);

        //Formatting date-times (something doesn't work too)
//        System.out.println("formatting date-times ===========");
//        DateTimeFormatter formatter =
//                DateTimeFormatter
//                    .ofPattern("MMM dd, yyyy - HH:mm");
//
//        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
//        String s = formatter.format(parsed);
//        System.out.println(s);


    }
}
