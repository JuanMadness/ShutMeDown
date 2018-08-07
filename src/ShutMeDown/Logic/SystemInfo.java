package ShutMeDown.Logic;

public class SystemInfo {

    public static final int UNKNOWN_OS = 0;
    public static final int LINUX = 1;
    public static final int WINDOWS = 2;
    public static final int MAC_OS = 3;

    private static int currentOS = 0;
    private static boolean isOSSet = false;

    public static int getOS(){
        if (!isOSSet) {
            final String tOS = System.getProperty("os.name");
            System.out.println("Detected OS: " + tOS);
            switch (tOS) {
                case "Linux":
                    currentOS = LINUX;
                    break;
                case "Windows XP":
                    currentOS = WINDOWS;
                    break;
                case "Windows Vista":
                    currentOS = WINDOWS;
                    break;
                case "Windows 7":
                    currentOS = WINDOWS;
                    break;
                case "Windows 8":
                    currentOS = WINDOWS;
                    break;
                case "Windows 8.1":
                    currentOS = WINDOWS;
                    break;
                case "Windows 10":
                    currentOS = WINDOWS;
                    break;
                default:
                    currentOS = UNKNOWN_OS;
                    break;
            }
            isOSSet = true;
        }
        return currentOS;
    }
}
