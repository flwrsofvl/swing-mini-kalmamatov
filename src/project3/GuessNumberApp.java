package project3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class GuessNumberApp extends JFrame implements ActionListener {

    JLabel labelTitle = new JLabel("Я загадал число от 1 до 100.");
    JLabel labelStatus = new JLabel("Введите число и нажмите кнопку.");
    JLabel labelAttempts = new JLabel("Попыток: 0");
    JTextField inputField = new JTextField(10);
    JButton btnCheck = new JButton("Проверить");

    int targetNumber;
    int count = 0;
    Random rand = new Random();

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

        btnCheck.addActionListener(this);
        targetNumber = rand.nextInt(100) + 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = inputField.getText();
        int userNum = Integer.parseInt(text);

        count++;
        labelAttempts.setText("Попыток: " + count);

        if (userNum == targetNumber) {
            labelStatus.setText("Вы угадали! Это число " + targetNumber);
        } else if (userNum < targetNumber) {
            labelStatus.setText("Мало! Загаданное число больше.");
        } else {
            labelStatus.setText("Много! Загаданное число меньше.");
        }
    }

    public static void main(String[] args) {
        GuessNumberApp app = new GuessNumberApp();
        app.setVisible(true);
    }
}