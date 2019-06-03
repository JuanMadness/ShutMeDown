package ShutMeDown.Logic.Shutdown;

import ShutMeDown.Logic.ConsoleCommand;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class AbstractShutdown {

    public abstract void shutdown(final int pSeconds);

    public abstract void cancelShutdown();

    public void shutdownOnTime(final int pHour, final int pMinute) {
        Date tDate = new Date();
        Calendar tCalendar = GregorianCalendar.getInstance();
        tCalendar.setTime(tDate);


        final int hourNow = tCalendar.get(Calendar.HOUR_OF_DAY);
        final int minuteNow = tCalendar.get(Calendar.MINUTE);
        final int dayInMin = 24 * 60;

        int tMinute = pHour * 60 + pMinute;
        int tMinuteNow = hourNow * 60 + minuteNow;

        if(tMinute < tMinuteNow) {
            tMinute = dayInMin - tMinuteNow + tMinute;
        } else if(tMinute > tMinuteNow) {
            tMinute = tMinute - tMinuteNow;
        } else if(tMinute == tMinuteNow) {
            tMinute = dayInMin;
        }

        int tHoures = tMinute / 60;
        int tMinutes = tMinute % 60;

        shutdownCountdown(tHoures, tMinutes, 0);
        System.out.println(tHoures + " " + tMinutes);
    }

    public void shutdownCountdown(final int pHours, final int pMinutes, final int pSeconds) {
        int tSeconds = pSeconds + 60 * pMinutes + 60 * 60 * pHours;
        shutdown(tSeconds);
    }

}
