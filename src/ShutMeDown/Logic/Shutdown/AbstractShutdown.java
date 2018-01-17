package ShutMeDown.Logic.Shutdown;

import ShutMeDown.Logic.ConsoleCommand;

import java.io.IOException;

public abstract class AbstractShutdown {

    public abstract void shutdown(final int pSeconds);

    public abstract void cancelShutdown();

    public void shutdownOnTime(final int pHour, final int pMinute) {

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
