package ShutMeDown.GUI.v2GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MenuPanel menuPanel = new MenuPanel();
    private JPanel startPanel;

    public MainFrame() {
        setLayout(new BorderLayout());
        add(BorderLayout.NORTH, menuPanel);

        startPanel = new JPanel();

        add(BorderLayout.CENTER, startPanel);


        setVisible(true);
    }
}
