package project3;

import java.awt.*;
import javax.swing.*;

public class GuessNumberApp extends JFrame {

    JLabel labelTitle = new JLabel("Я загадал число от 1 до 100.");
    JLabel labelStatus = new JLabel("Введите число и нажмите кнопку.");
    JLabel labelAttempts = new JLabel("Попыток: 0");
    JTextField inputField = new JTextField(10);
    JButton btnCheck = new JButton("Проверить");

    public GuessNumberApp() {
        setTitle("Угадай число");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1));

        JPanel inputPanel = new JPanel();
        inputPanel.add(inputField);
        inputPanel.add(btnCheck);

        add(labelTitle);
        add(inputPanel);
        add(labelStatus);
        add(labelAttempts);
    }

    public static void main(String[] args) {
        GuessNumberApp app = new GuessNumberApp();
        app.setVisible(true);
    }
}