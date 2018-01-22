package ShutMeDown.GUI.v2GUI;

import ShutMeDown.GUI.v2GUI.v2GUIComponents.V2Button;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private V2Button btnCountdown, btnTimer;

    public MenuPanel() {
        setLayout(new GridLayout(1, 2));

        btnCountdown = new V2Button();
        btnCountdown.setText("Countdown");
        add(btnCountdown);

        btnTimer = new V2Button();
        btnTimer.setText("Timer");
        add(btnTimer);
    }
}
