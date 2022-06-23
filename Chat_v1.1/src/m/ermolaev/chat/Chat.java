package m.ermolaev.chat;
import m.ermolaev.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

public class Chat {
    private Client mClient;
    private JPanel mainPanel;
    private JPanel messagePanel;
    private JTextField messageTextField;
    private JPanel inputMessagePanel;
    private JLabel messageLabel;
    private JLabel chatLabel;
    private JTextArea chatTextArea;

    public Chat(String username, Color clientColour)
    {
        mainPanel.setBackground(clientColour);
        messagePanel.setForeground(clientColour);

        messageTextField.setForeground(clientColour);
        chatTextArea.setForeground(clientColour);
        JFrame mainFrame = new JFrame("Chat v 1.2");
        chatLabel.setText("Your nickname: " + username);
        mainFrame.setContentPane(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.pack();
        mainFrame.setVisible(true);


        try {
            Socket socket = new Socket("localhost", 6666);
            mClient = new Client(socket, username);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        readMessage();

        messageTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = "";
                temp = messageTextField.getText();
                if (!Objects.equals(temp, "")) {
                    mClient.sendMessage(temp);
                    chatTextArea.setText(chatTextArea.getText() + temp + "\n");
                    messageTextField.setText("");
                }
            }
        });
    }

    private void readMessage() {
        new Thread(new Runnable() {
            String message;

            @Override
            public void run() {
                while ((message = mClient.waitForMessage()) != null)
                    chatTextArea.setText(chatTextArea.getText() + message + "\n");
            }
        }).start();
    }
}