import java.time.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    private static final Set<Integer> weekendDaysOfMay = Set.of(1,4,5,9,10,11,12,18,19,25,26);

    public static void main(String[] args) {
        System.out.println(isWeekendDate(LocalDate.now()));
        System.out.println(isWeekendDate(LocalDate.of(2024, Month.MAY, 2)));
        System.out.println(isWeekendDate(LocalDate.of(2024, Month.MAY, 9)));

        ZoneId  timezoneAPR = ZoneId.of("America/Puerto_Rico");
        ZoneId  timezoneEM = ZoneId.of("Europe/Moscow");

        System.out.println(isWeekendDateTime(ZonedDateTime.of(getLDT().get(0), timezoneEM)));
        System.out.println(isWeekendDateTime(ZonedDateTime.of(getLDT().get(1), timezoneEM)));
        System.out.println(isWeekendDateTime(ZonedDateTime.of(getLDT().get(2), timezoneEM)));
        System.out.println(isWeekendDateTime(ZonedDateTime.of(getLDT().get(3), timezoneEM)));
        System.out.println(isWeekendDateTime(ZonedDateTime.of(getLDT().get(4), timezoneEM)));
        System.out.println("-------------------------------------");
        System.out.println(isWeekendDateTime(ZonedDateTime.now(timezoneAPR)));
    }
    public static boolean isWeekendDate(LocalDate ld) {
        return weekendDaysOfMay.contains(ld.getDayOfMonth());
    }

    public static boolean isWeekendDateTime(ZonedDateTime ldt) {
        if(weekendDaysOfMay.contains(ldt.getDayOfMonth())) {
            return true;
        }
        if(ldt.getHour() == 12) {
            if (ldt.getMinute() < 46) {
                return true;
            }else return false;
        }
        if(ldt.getHour() >= 9 && ldt.getHour() < 12 || ldt.getHour() > 12 && ldt.getHour() < 18 ) {
            return false;
        }
        return true;
    }

    private static List<LocalDateTime> getLDT() {
        return Arrays.asList(
                LocalDateTime.of(2024, Month.MAY, 2, 10, 30),
                LocalDateTime.of(2024, Month.MAY, 2, 12, 30),
                LocalDateTime.of(2024, Month.MAY, 2, 15, 30),
                LocalDateTime.of(2024, Month.MAY, 2, 19, 10),
                LocalDateTime.of(2024, Month.MAY, 9, 10, 30)
        );
    }
}