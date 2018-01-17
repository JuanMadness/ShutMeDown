package ShutMeDown.Logic;

import java.io.IOException;

public class ConsoleCommand {

    public static void runCmd(final String pCmd) throws IOException {
        Runtime.getRuntime().exec(pCmd);
    }
}
