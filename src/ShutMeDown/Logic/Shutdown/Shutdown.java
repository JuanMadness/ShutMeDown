package ShutMeDown.Logic.Shutdown;

import ShutMeDown.Logic.SystemInfo;

public class Shutdown {

    public static final int CANCEL_SHUTDOWN = 0;
    public static final int SHUTDOWN_COUNTDOWN = 1;
    public static final int SHUTDOWN_TIMER = 2;

    public static void doShutdown(final int pMode, final int[] time) {
        AbstractShutdown tShutdown = null;
        final int tOS = SystemInfo.getOS();
        if(tOS == SystemInfo.WINDOWS) {
            tShutdown = new ShutdownWin();
        } else if(tOS == SystemInfo.LINUX) {
            tShutdown = new ShutdownLinux();
        } else if(tOS == SystemInfo.MAC_OS) {
            throw new IllegalArgumentException("Your OS is not supported!");
        } else if(tOS == SystemInfo.UNKNOWN_OS) {
            throw new IllegalArgumentException("Your OS is not supported!");
        }
        if(pMode == SHUTDOWN_COUNTDOWN && time.length == 3) {
            tShutdown.shutdownCountdown(time[0], time[1], time[2]);
        } else if(pMode == SHUTDOWN_TIMER && time.length == 2) {
            tShutdown.shutdownOnTime(time[0], time[1]);
        } else if(pMode == CANCEL_SHUTDOWN) {
            tShutdown.cancelShutdown();
        } else {
            throw new IllegalArgumentException("False parameters!");
        }
    }

    public static void cancelShutdown() {
        doShutdown(CANCEL_SHUTDOWN, null);
    }
}
