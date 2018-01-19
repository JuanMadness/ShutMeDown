package ShutMeDown.GUI.SimpleGUI;

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
        lblHour.setHorizontalAlignment(JLabel.CENTER);
        add(lblHour);

        lblMinute = new JLabel("Minutes");
        lblMinute.setHorizontalAlignment(JLabel.CENTER);
        add(lblMinute);

        lblSecond = new JLabel("Seconds");
        lblSecond.setHorizontalAlignment(JLabel.CENTER);
        add(lblSecond);

        txtHour = new JTextField();
        txtHour.setHorizontalAlignment(JTextField.CENTER);
        txtHour.setText("1");
        add(txtHour);

        txtMinute = new JTextField();
        txtMinute.setHorizontalAlignment(JTextField.CENTER);
        txtMinute.setText("10");
        add(txtMinute);

        txtSecond = new JTextField();
        txtSecond.setHorizontalAlignment(JTextField.CENTER);
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

        btnCancel = new JButton("Cancel Shutdown");
        btnCancel.setActionCommand("cancel");
        btnCancel.addActionListener(this);
        add(btnCancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("cancel")){
            Shutdown.cancelShutdown();
        } else if(e.getActionCommand().equals("countdown")) {
            int[] tTime = new int[3];
            tTime[0] = Integer.parseInt(txtHour.getText());
            tTime[1] = Integer.parseInt(txtMinute.getText());
            tTime[2] = Integer.parseInt(txtSecond.getText());
            Shutdown.doShutdown(Shutdown.SHUTDOWN_COUNTDOWN, tTime);
        } else if(e.getActionCommand().equals("timer")) {
            int[] tTime = new int[2];
            tTime[0] = Integer.parseInt(txtHour.getText());
            tTime[1] = Integer.parseInt(txtMinute.getText());
            Shutdown.doShutdown(Shutdown.SHUTDOWN_TIMER, tTime);
        }
    }
}
