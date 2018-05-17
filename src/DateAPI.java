import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateAPI {


    public static void main(String[] args) {
        //Clock
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);

        //Timezones
        System.out.println(ZoneId.getAvailableZoneIds());
        //prints all available timezone ids

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        //LocalTime
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

        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);


    }
}
