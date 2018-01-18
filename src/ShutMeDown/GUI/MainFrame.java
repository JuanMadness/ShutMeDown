package ShutMeDown.GUI;

import ShutMeDown.Logic.Shutdown.Shutdown;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    private JButton btnCountdown, btnTimer, btnCancel;
    private JTextField txtHour, txtMinute, txtSecond;
    private JLabel lblHour, lblMinute, lblSecond;

    public MainFrame() {
        setLayout(new GridLayout(3,3));
        setTitle("ShutMeDown SimpleGUI");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 120);
        setResizable(false);

        lblHour = new JLabel("Hours");
        add(lblHour);

        lblMinute = new JLabel("Minutes");
        add(lblMinute);

        lblSecond = new JLabel("Seconds");
        add(lblSecond);

        txtHour = new JTextField();
        txtHour.setText("1");
        add(txtHour);

        txtMinute = new JTextField();
        txtMinute.setText("10");
        add(txtMinute);

        txtSecond = new JTextField();
        txtSecond.setText("30");
        add(txtSecond);

        btnCountdown = new JButton("Countdown");
        btnCountdown.setActionCommand("countdown");
        btnCountdown.addActionListener(this);
        add(btnCountdown);

        btnTimer = new JButton("Timer");
        btnTimer.setActionCommand("timer");
        btnTimer.addActionListener(this);
        add(btnTimer);

        btnCancel = new JButton("Cancel");
        btnCancel.setActionCommand("cancel");
        btnCancel.addActionListener(this);
        add(btnCancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int[] tTime = new int[3];
        tTime[0] = Integer.parseInt(txtHour.getText());
        tTime[1] = Integer.parseInt(txtMinute.getText());
        tTime[2] = Integer.parseInt(txtSecond.getText());
        if(e.getActionCommand().equals("cancel")){
            Shutdown.cancelShutdown();
        } else if(e.getActionCommand().equals("countdown")) {
            Shutdown.doShutdown(Shutdown.SHUTDOWN_COUNTDOWN, tTime);
        } else if(e.getActionCommand().equals("timer")) {
            Shutdown.doShutdown(Shutdown.SHUTDOWN_TIMER, tTime);
        }
    }
}
