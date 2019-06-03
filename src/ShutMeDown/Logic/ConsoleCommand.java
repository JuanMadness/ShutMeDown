package ShutMeDown.Logic;

import java.io.IOException;

public class ConsoleCommand {

    public static void runCmd(final String pCmd) {
        try {
            Runtime.getRuntime().exec(pCmd);
        } catch (Exception pE) {
            System.out.println("ERROR");
        }

    }
}
