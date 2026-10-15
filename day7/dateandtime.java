
import java.time.*;
import java.time.format.DateTimeFormatter;

public class dateandtime {
    public static void main(String[] args) {

        // 1. Local Time
        System.out.println("local time  ");
        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime t = LocalTime.of(10, 30, 0);
        System.out.println("Custom Time: " + t);

        LocalTime t1 = LocalTime.parse("12:30:10");
        System.out.println("Parsed Time: " + t1);

        //Local Date
        System.out.println("local date  ");
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDate d = LocalDate.of(2023, 6, 15);
        System.out.println("Custom Date: " + d);

        //LocalDateTime 
        System.out.println("local date time  ");
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        LocalDateTime dt = LocalDateTime.of(2023, 6, 15, 10, 30, 0);
        System.out.println("Custom DateTime: " + dt);

        //ZonedDateTime
        System.out.println("Zoned date time  ");   
        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);

        System.out.println("Zoned date time with specific zone  ");
        ZonedDateTime zdt1 = ZonedDateTime.of(2023, 6, 15, 10, 30, 0, 0, ZoneId.of("Asia/Kolkata"));
        System.out.println(zdt1);

        //Time preiod
        System.out.println("Time period  ");
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 6, 15);
        Period period = Period.between(startDate, endDate);
        System.out.println("years: " + period.getYears());
        System.out.println(" months: " + period.getMonths());
        System.out.println(" days: " + period.getDays());

        //duration
        System.out.println("Duration  ");
        LocalTime startTime = LocalTime.of(10, 30, 0); 
        LocalTime endTime = LocalTime.of(12, 45, 0);
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("hours: " + duration.toHours());
        System.out.println("minutes: " + duration.toMinutes());

        //DateTime formatting
        System.out.println("DateTime formatting  ");
        LocalDateTime dateTime1 = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String form = dateTime1.format(format);
        System.out.println("Formatted DateTime: " + form);

    }
}





// local time 
// local date
// localdatetime 
// zoned date 
// time period 
// duration 
// datetime formatiing