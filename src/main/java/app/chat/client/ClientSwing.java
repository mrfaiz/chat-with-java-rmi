/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.chat.client;

import app.chat.interfaces.IChatClient;
import app.chat.interfaces.IChatServer;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Faiz Ahmed
 */
public class ClientSwing {

    private static final String CLIENT_NAME = "CLIENT_6";

    /**
     * Chat client UI
     */
    static class ChatFrame extends JFrame implements Observer {

        private JTextArea textArea;
        private JTextField inputTextField;
        private JButton sendButton;
        private final ChatAccess chatAccess;
        private final IChatServer chatServer;
        private final IChatClient chatClient;

        public ChatFrame(ChatAccess chatAccess, IChatServer chatServer1, IChatClient chatClient) {
            this.chatAccess = chatAccess;
            chatAccess.addObserver(this);
            this.chatServer = chatServer1;
            this.chatClient = chatClient;
            buildGUI();
        }

        /**
         * Builds the user interface
         */
        private void buildGUI() {
            textArea = new JTextArea(20, 50);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            add(new JScrollPane(textArea), BorderLayout.CENTER);

            Box box = Box.createHorizontalBox();
            add(box, BorderLayout.SOUTH);
            inputTextField = new JTextField();
            sendButton = new JButton("Send");
            box.add(inputTextField);
            box.add(sendButton);

            ActionListener sendListener = (ActionEvent e) -> {
                String str = inputTextField.getText();
                if (str != null && str.trim().length() > 0) // chatAccess.send(str);
                {
                    try {
                        chatServer.send(str, CLIENT_NAME);
                        chatAccess.notifyObservers(CLIENT_NAME + ":" + str);
                    } catch (java.rmi.RemoteException ex) {
                        chatAccess.notifyObservers(str);
                    }
                    inputTextField.selectAll();
                }
                inputTextField.requestFocus();
                inputTextField.setText("");
            };
            inputTextField.addActionListener(sendListener);
            sendButton.addActionListener(sendListener);

            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    try {
                        boolean signout = chatServer.logout(chatClient);
                    } catch (java.rmi.RemoteException ex) {
                    }
                }
            });
        }

        /**
         * Updates the UI depending on the Object argument
         */
        @Override
        public void update(Observable o, Object arg) {
            final Object finalArg = arg;
            SwingUtilities.invokeLater(() -> {
                textArea.append(finalArg.toString());
                textArea.append("\n");
            });
        }
    }

    public static void main(String[] args) {
        String host = args.length > 1 ? args[0] : "localhost";
        String uri = "rmi://" + host + "/ChatServer";

        ChatAccess access = new ChatAccess();
        try {
            ChatclientImplementSwing chatclientImplement = new ChatclientImplementSwing(CLIENT_NAME, access);
            java.rmi.registry.Registry reg = java.rmi.registry.LocateRegistry.getRegistry(1099);
            IChatServer iChatServer = (IChatServer) reg.lookup(uri);
            JFrame frame = new ChatFrame(access, iChatServer, chatclientImplement);

            frame.setTitle(CLIENT_NAME);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);

            boolean success = iChatServer.register(chatclientImplement, CLIENT_NAME);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }

        // Then, somewhere in your code
    }
}
