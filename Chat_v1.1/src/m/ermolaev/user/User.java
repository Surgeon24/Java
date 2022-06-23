package m.ermolaev.user;

import m.ermolaev.chat.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class User {
    private static JFrame mainFrame;
    public static User mForm;
    private Chat clientInterface;
    private JPanel mainPanel;

    private JTextField inputNameTextField;
    private JLabel inputNameLabel;

    public User() {
        Color clientColour = new Color(69, 69, 69);
        mainFrame.setBackground(clientColour);
        inputNameTextField.setForeground(clientColour);

        inputNameTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Objects.equals(inputNameTextField.getText(), "")) {
                    clientInterface = new Chat(inputNameTextField.getText(), clientColour);
                    mainFrame.dispose();
                }
            }
        });
    }

    public static void main(String[] args) {
        mainFrame = new JFrame();
        mForm = new User();
        mainFrame.setContentPane(mForm.mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}