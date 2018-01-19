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

        int tMinutes = 0;
        int tHoures = 0;

        if(pHour < hourNow) {
            tHoures = 24 - (hourNow - pHour);
        } else if(pHour > hourNow) {
            tHoures = pHour - hourNow;
        } else {
            tHoures = 0;
        }

        if(pMinute < minuteNow) {
            tMinutes = 60 - (minuteNow - pMinute);
        } else if(pMinute > minuteNow) {
            tMinutes = pMinute - minuteNow;
        } else {
            tMinutes = 0;
        }

        if(tHoures == 0 && tMinutes == 0) {
            tHoures = 24;
        }
        //tHoures = tHoures - 1;
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
