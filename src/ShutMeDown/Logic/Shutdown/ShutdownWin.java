package ShutMeDown.Logic.Shutdown;

import ShutMeDown.Logic.ConsoleCommand;

import java.io.IOException;

public class ShutdownWin extends AbstractShutdown {
    @Override
    public void shutdown(final int pSeconds) {
        final String tCommand = "shutdown -s -f -t " + pSeconds;
        ConsoleCommand.runCmd(tCommand);
    }

    @Override
    public void cancelShutdown() {
        final String tCommand = "shutdown -a";
        ConsoleCommand.runCmd(tCommand);
    }
}
