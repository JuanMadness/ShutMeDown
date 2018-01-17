package ShutMeDown.Logic;

public class SystemInfo {

    public static final int UNKNOWN_OS = 0;
    public static final int LINUX = 1;
    public static final int WINDOWS = 2;
    public static final int MAC_OS = 3;

    public static int getOS(){
        final String tOS = System.getProperty("os.name");
        return WINDOWS;
    }
}
