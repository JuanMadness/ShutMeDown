package ShutMeDown.GUI.v2GUI;

import ShutMeDown.GUI.v2GUI.v2GUIComponents.V2Button;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private V2Button btnCountdown, btnTimer, btnHome, btn4;

    public MenuPanel() {
        setLayout(new GridLayout(1, 4));

        btnHome = new V2Button();
        btnHome.setText("HOME");
        add(btnHome);

        btnCountdown = new V2Button();
        btnCountdown.setText("Countdown");
        add(btnCountdown);

        btnTimer = new V2Button();
        btnTimer.setText("Timer");
        add(btnTimer);

        btn4 = new V2Button();
        btn4.setText("FolderControl");
        add(btn4);
    }
}
