package org.example.view;

import org.example.config.DBConnection;
import org.example.constant.ErrorConstant;
import org.example.repository.AdminRepository;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class Login {
    private JPanel login;
    private JTextField usernameTF;
    private JButton loginButton;
    private JPasswordField passwordTF;

    private AdminRepository adminRepository = new AdminRepository(DBConnection.getConnection());

    public Login(final JFrame jFrame) throws SQLException, ClassNotFoundException {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String responseLogin = adminRepository.Login(usernameTF.getText(),passwordTF.getText());
                    if(responseLogin.equals(ErrorConstant.CREDENTIAL_VALID)){
                        Home home = new Home(jFrame);
                        jFrame.getContentPane().removeAll();
                        jFrame.add(home.getHome());
                        jFrame.repaint();
                        jFrame.setVisible(true);

                    }
                    else if (responseLogin.equals(ErrorConstant.CREDENTIAL_INVALID)){
                        JOptionPane.showMessageDialog(jFrame, "Invalid Username / Password .");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
    }
    public JPanel getLogin() {
        return login;
    }
}
