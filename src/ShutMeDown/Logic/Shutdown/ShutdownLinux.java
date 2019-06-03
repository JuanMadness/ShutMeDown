package ShutMeDown.Logic.Shutdown;

import ShutMeDown.Logic.ConsoleCommand;

public class ShutdownLinux extends AbstractShutdown {
    @Override
    public void shutdown(int pSeconds) {
        final String pCommand = "shutdown -P -t " + pSeconds;
        ConsoleCommand.runCmd(pCommand);
    }

    @Override
    public void shutdownOnTime(final int pHour, final int pMinute){
        if(pHour > 24 || pHour < 0 || pMinute > 59 || pMinute < 0) return;
        final String pCommand = "shutdown -P " + pHour + ":" + pMinute;
        ConsoleCommand.runCmd(pCommand);
    }

    @Override
    public void cancelShutdown() {
        final String pCommand = "shutdown -c";
        ConsoleCommand.runCmd(pCommand);
    }
}
