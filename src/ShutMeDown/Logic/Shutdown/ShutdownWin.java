package ShutMeDown.Logic.Shutdown;

public class ShutdownWin extends AbstractShutdown {
    @Override
    public void shutdown() {
        int tSeconds = 0; //Platzhalter
        final String command = "shutdown -s -f -t " + tSeconds;
        runCommand(command);
    }

    @Override
    public void cancelShutdown() {
        final String command = "shutdown -a";
        runCommand(command);
    }
}
