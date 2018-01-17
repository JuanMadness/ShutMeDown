package ShutMeDown.Logic.Shutdown;

import java.io.IOException;

public class ShutdownWin extends AbstractShutdown {
    @Override
    public void shutdown(final int pSeconds) {
        final String command = "shutdown -s -f -t " + pSeconds;
        runCommand(command);
    }

    @Override
    public void cancelShutdown() {
        final String command = "shutdown -a";
        runCommand(command);
    }
}
