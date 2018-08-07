package ShutMeDown.GUI.SimpleGUI;

import ShutMeDown.Logic.Shutdown.Shutdown;
import ShutMeDown.Logic.SystemInfo;

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
        setTitle("ShutMeDown");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 120);
        setLocation(500, 500);
        setResizable(false);

        lblHour = new JLabel("Hours");
        lblHour.setHorizontalAlignment(JLabel.CENTER);
        lblHour.setOpaque(true);
        lblHour.setBackground(Color.WHITE);
        add(lblHour);

        lblMinute = new JLabel("Minutes");
        lblMinute.setHorizontalAlignment(JLabel.CENTER);
        lblMinute.setOpaque(true);
        lblMinute.setBackground(Color.WHITE);
        add(lblMinute);

        lblSecond = new JLabel("Seconds");
        lblSecond.setHorizontalAlignment(JLabel.CENTER);
        lblSecond.setOpaque(true);
        lblSecond.setBackground(Color.WHITE);
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
        btnCountdown.setBackground(Color.WHITE);
        btnCountdown.setActionCommand("countdown");
        btnCountdown.addActionListener(this);
        add(btnCountdown);

        btnTimer = new JButton("Timer");
        btnTimer.setBackground(Color.WHITE);
        btnTimer.setActionCommand("timer");
        btnTimer.addActionListener(this);
        add(btnTimer);

        btnCancel = new JButton("Cancel Shutdown");
        btnCancel.setBackground(Color.WHITE);
        btnCancel.setActionCommand("cancel");
        btnCancel.addActionListener(this);
        add(btnCancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(txtSecond.getText().trim().equals("")) {
            txtSecond.setText("0");
        }
        if(txtMinute.getText().trim().equals("")) {
            txtMinute.setText("0");
        }
        if(txtHour.getText().trim().equals("")) {
            txtHour.setText("0");
        }
        try {
            if (e.getActionCommand().equals("cancel")) {
                Shutdown.cancelShutdown();
            } else if (e.getActionCommand().equals("countdown")) {
                int[] tTime = new int[3];
                tTime[0] = Integer.parseInt(txtHour.getText());
                tTime[1] = Integer.parseInt(txtMinute.getText());
                tTime[2] = Integer.parseInt(txtSecond.getText());
                if (isGreaterZero(tTime)) {
                    Shutdown.doShutdown(Shutdown.SHUTDOWN_COUNTDOWN, tTime);
                } else {
                    JOptionPane.showMessageDialog(this, "ShutdownCountdown: Wrong use!", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (e.getActionCommand().equals("timer")) {
                int[] tTime = new int[2];
                tTime[0] = Integer.parseInt(txtHour.getText());
                tTime[1] = Integer.parseInt(txtMinute.getText());
                if (isGreaterZero(tTime) && isGreater23(tTime)) {
                    Shutdown.doShutdown(Shutdown.SHUTDOWN_TIMER, tTime);
                } else {
                    JOptionPane.showMessageDialog(this, "ShutdownTimer: Wrong use!", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch(NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "Wrong use! Only numbers allowed!", "Information", JOptionPane.WARNING_MESSAGE);
        }
    }

    private boolean isGreaterZero(int[] pValues) {
        for (Integer a: pValues) {
            if(a < 0) return false;
        }
        return true;
    }

    private boolean isGreater23(int[] pValues) {
        if(pValues[0] > 23) return false;
        if(pValues[1] > 59) return false;
        return true;
    }
}
