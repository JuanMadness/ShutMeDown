package ShutMeDown.Logic;

public class SystemInfo {

    public static final int UNKNOWN_OS = 0;
    public static final int LINUX = 1;
    public static final int WINDOWS = 2;
    public static final int MAC_OS = 3;

    public static int getOS(){
        final String tOS = System.getProperty("os.name");
        System.out.println("Detected OS: " + tOS);
        switch (tOS) {
            case "Linux":
                return LINUX;
            case "Windows XP":
                return WINDOWS;
            case "Windows Vista":
                return WINDOWS;
            case "Windows 7":
                return WINDOWS;
            case "Windows 8":
                return WINDOWS;
            case "Windows 8.1":
                return WINDOWS;
            case "Windows 10":
                return WINDOWS;
            default:
                return UNKNOWN_OS;

        }
    }
}
