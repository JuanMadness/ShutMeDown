package ShutMeDown;


import ShutMeDown.GUI.SimpleGUI.MainFrame;
import ShutMeDown.Logic.SystemInfo;

import javax.swing.*;

public class Start {

    public static void main(String args[]) {


        if (SystemInfo.getOS() == SystemInfo.UNKNOWN_OS) {
            JOptionPane.showMessageDialog(null, System.getProperty("os.name") + " not supported!", "OS not supported!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        new MainFrame();
    }
}
