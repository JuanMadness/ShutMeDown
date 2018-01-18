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

        if(minuteNow != 0) {
            tMinutes = 60 - minuteNow;
            tHoures = -1;
        }
        tMinutes = pMinute;

        if(pHour < hourNow) {
            tHoures = tHoures + 24 - hourNow + pHour;
        } else if(pHour > hourNow) {
            tHoures = tHoures + pHour - hourNow;
        } else if(pHour == hourNow) {
            if(pMinute > minuteNow) {
                tHoures = 0;
            } else if(pMinute < minuteNow) {
                tHoures = 23;
                tMinutes = 60 - (minuteNow - pMinute);
            } else if(pMinute == minuteNow) {
                tHoures = 24;
                tMinutes = 0;
            }
        }
        //shutdownCountdown(tHoures, tMinutes, 0);
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
