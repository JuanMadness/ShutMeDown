package ShutMeDown.Logic.Shutdown;

import ShutMeDown.Logic.ConsoleCommand;

import java.io.IOException;
import java.util.Date;

public abstract class AbstractShutdown {

    public abstract void shutdown(final int pSeconds);

    public abstract void cancelShutdown();

    public void shutdownOnTime(final int pHour, final int pMinute) {
        Date tDate = new Date();
        final int hourNow = tDate.getHours();
        final int minuteNow = tDate.getMinutes();
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

    protected void runCommand(final String pCommand){
        try {
            ConsoleCommand.runCmd(pCommand);
        } catch (IOException e) {
            System.out.println("Can´t run shutdown-Command!");
        }
    }
}
