package ShutMeDown;


import ShutMeDown.GUI.SimpleGUI.MainFrame;
import ShutMeDown.Logic.Shutdown.Shutdown;

public class Start {

    public static void main(String args[]) {
        if(args.length != 0 && args[0].equals("-nogui")) {
            switch (args[1]){
                case "timer":
                    if(args.length == 4) {
                        int[] tTime = new int[2];
                        tTime[0] = Integer.parseInt(args[2]);
                        tTime[1] = Integer.parseInt(args[3]);
                        Shutdown.doShutdown(Shutdown.SHUTDOWN_TIMER, tTime);
                        System.out.println("Done!");
                    }
                    break;
                case "countdown":
                    if(args.length == 5) {
                        int[] tTime = new int[3];
                        tTime[0] = Integer.parseInt(args[2]);
                        tTime[1] = Integer.parseInt(args[3]);
                        tTime[2] = Integer.parseInt(args[4]);
                        Shutdown.doShutdown(Shutdown.SHUTDOWN_COUNTDOWN, tTime);
                        System.out.println("Done!");
                    }
                    break;
                case "cancel":
                    Shutdown.cancelShutdown();
                    break;
                default:
                    System.out.println("-nogui [timer|countdown|cancel] [hour|hours] [minute|minutes] [seconds]");
            }
        } else {
            new MainFrame();
        }
    }
}
