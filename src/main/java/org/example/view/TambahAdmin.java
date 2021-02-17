package org.example.view;

import org.example.config.DBConnection;
import org.example.constant.ErrorConstant;
import org.example.model.Admin;
import org.example.repository.AdminRepository;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TambahAdmin {
    private JPanel tambahAdmin;
    private JPasswordField passwordTF;
    private JTextField namaAdminTF;
    private JTextField alamatTF;
    private JTextField emailTF;
    private JTextField telpTF;

    public JPanel getTambahAdmin() {
        return tambahAdmin;
    }

    private JTextField statusTF;
    private JButton registerButton;
    private JButton kembaliButton;

    private AdminRepository adminRepository = new AdminRepository(DBConnection.getConnection());

    public TambahAdmin(final JFrame jFrame) throws SQLException, ClassNotFoundException {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(passwordTF.getText().isEmpty() || namaAdminTF.getText().isEmpty() || alamatTF.getText().isEmpty() || emailTF.getText().isEmpty() || telpTF.getText().isEmpty() || statusTF.getText().isEmpty()){
                    JOptionPane.showMessageDialog(jFrame, "Please Input All Text Field .");
                }
                else {
                    Admin admin = new Admin(0, namaAdminTF.getText(), passwordTF.getText(), alamatTF.getText(),emailTF.getText(), telpTF.getText(), Integer.parseInt(statusTF.getText()));
                    String response = adminRepository.createAdmin(admin);

                    if(response.equals(ErrorConstant.CREATE_ACCOUNT_SUCCESS)){
                        JOptionPane.showMessageDialog(jFrame, "Create Account Success !.");
                    }
                    else if (response.equals(ErrorConstant.CREATE_ACCOUNT_FAILED)){
                        JOptionPane.showMessageDialog(jFrame, "Create Account Failed !.");
                    }

                }
            }
        });
        kembaliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home home = new Home(jFrame);
                jFrame.getContentPane().removeAll();
                jFrame.add(home.getHome());
                jFrame.repaint();
                jFrame.setVisible(true);
            }
        });
    }
}
