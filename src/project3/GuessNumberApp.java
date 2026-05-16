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
    JButton btnRestart = new JButton("Новая игра");

    int targetNumber;
    int count = 0;
    Random rand = new Random();

    public GuessNumberApp() {
        setTitle("Угадай число");
        setSize(350, 230); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));

        JPanel inputPanel = new JPanel();
        inputPanel.add(inputField);
        inputPanel.add(btnCheck);

        add(labelTitle);
        add(inputPanel);
        add(labelStatus);
        add(labelAttempts);
        add(btnRestart);

        btnCheck.addActionListener(this);
        btnRestart.addActionListener(this); 

        btnRestart.setVisible(false);

        targetNumber = rand.nextInt(100) + 1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRestart) {
            targetNumber = rand.nextInt(100) + 1;
            count = 0;
            labelAttempts.setText("Попыток: 0");
            labelStatus.setText("Введите число и нажмите кнопку.");
            inputField.setText("");
            inputField.setEnabled(true);
            btnCheck.setEnabled(true);
            btnRestart.setVisible(false);
            return;
        }

        try {
            String text = inputField.getText();
            int userNum = Integer.parseInt(text);

            if (userNum < 1 || userNum > 100) {
                labelStatus.setText("Введите число строго от 1 до 100!");
                return;
            }

            count++;
            labelAttempts.setText("Попыток: " + count);

            if (userNum == targetNumber) {
                labelStatus.setText("Вы угадали! Это было число " + targetNumber);
                inputField.setEnabled(false); 
                btnCheck.setEnabled(false); 
                btnRestart.setVisible(true); 
            } else if (userNum < targetNumber) {
                labelStatus.setText("Мало! Загаданное число больше.");
            } else {
                labelStatus.setText("Много! Загаданное число меньше.");
            }

        } catch (NumberFormatException ex) {
            labelStatus.setText("Ошибка! Нужно ввести именно число.");
        }
    }

    public static void main(String[] args) {
        GuessNumberApp app = new GuessNumberApp();
        app.setVisible(true);
    }
}