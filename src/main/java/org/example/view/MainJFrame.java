package org.example.view;

import javax.swing.*;
import java.sql.SQLException;

public class MainJFrame {
    public static void createGUI() throws SQLException, ClassNotFoundException {
        JFrame frame = new JFrame("Sistem Informasi Perpustakaan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login login = new Login(frame);
        frame.add(login.getLogin());
        frame.setVisible(true);
        frame.pack();
        frame.setSize(900,350);
    }
}
