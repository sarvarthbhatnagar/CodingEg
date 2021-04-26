import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class TripPlanning {

    public static void main(String[] args) {
        System.out.println("sol: " + solution(2014, "April", "May", "Wednesday"));
    }

    public static int solution(int Y, String A, String B, String W) {

        /**
         * 1 = monday
         * 7 = sunday
         */
        int year = Y;
        int startMonth = Month.valueOf(A.toUpperCase()).getValue();
        int endMonth = Month.valueOf(B.toUpperCase()).getValue();

        Date convertedDate = new Date(year, endMonth, 01);
        Calendar c = Calendar.getInstance();
        c.setTime(convertedDate);
        LocalDate endDateArb = LocalDate.of(year, endMonth, 01);
        LocalDate lastDay = endDateArb.with(TemporalAdjusters.lastDayOfMonth()); //2015-11-30

        final LocalDate endDate = LocalDate.of(year, endMonth, lastDay.getDayOfMonth());
        final LocalDate startDate = LocalDate.of(year, startMonth, 01);
        long noOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        int successWeek = 0;
        int startWeekday = startDate.getDayOfWeek().getValue() - 1;
        int diffDays = (int) noOfDaysBetween;
        boolean beginweek = false;
        for (int i = 0; i < diffDays; i++) {
            startWeekday++;
            if (startWeekday == 1) {
                beginweek = true;
            }
            if (startWeekday == 7) {
                if (beginweek) {
                    successWeek++;
                    beginweek = false;
                }
                startWeekday = 0;
            }
        }

        return successWeek;

        // write your code in Java SE 8
    }
}
