package org.example.view;

import org.example.config.DBConnection;
import org.example.constant.ErrorConstant;
import org.example.model.Admin;
import org.example.model.Penyewa;
import org.example.repository.PenyewaRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TambahMember {
    private JPanel tambahMember;
    private JTextField namaMemberTF;
    private JTextField alamatMemberTF;
    private JTextField emailMemberTF;
    private JTextField teleponMemberTF;
    private JButton registerButton;
    private JButton kembaliButton;

    public JPanel getTambahMember(){
        return tambahMember;
    }

    private PenyewaRepository penyewaRepository = new PenyewaRepository(DBConnection.getConnection());

    public TambahMember(final JFrame jFrame) throws SQLException, ClassNotFoundException {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(namaMemberTF.getText().isEmpty() || alamatMemberTF.getText().isEmpty() || emailMemberTF.getText().isEmpty() || teleponMemberTF.getText().isEmpty()){
                    JOptionPane.showMessageDialog(jFrame, "Please Input All Text Field .");
                }
                else {
                    Penyewa penyewa = new Penyewa(namaMemberTF.getText(),alamatMemberTF.getText(),emailMemberTF.getText(),teleponMemberTF.getText());
                    String response = penyewaRepository.createPenyewa(penyewa);

                    if(response.equals(ErrorConstant.CREATE_MEMBER_SUCCESS)){
                        JOptionPane.showMessageDialog(jFrame, "Create Member Success !.");
                    }
                    else if (response.equals(ErrorConstant.CREATE_MEMBER_FAILED)){
                        JOptionPane.showMessageDialog(jFrame, "Create Member Failed !.");
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
