package org.example.view;

import org.example.config.DBConnection;
import org.example.constant.ErrorConstant;
import org.example.model.Sewa;
import org.example.repository.SewaRepository;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SewaBuku {
    private JPanel sewaBuku;
    private JTextField idAdminTF;
    private JTextField idPenyewaTF;
    private JTextField tanggalSewaTF;
    private JTextField tanggalKembaliTF;
    private JTextField idBukuTF;
    private JButton sewaButton;
    private JButton kembaliButton;

    private SewaRepository sewaRepository = new SewaRepository(DBConnection.getConnection());

    public SewaBuku(final JFrame jFrame) throws SQLException, ClassNotFoundException {

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
        sewaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(idAdminTF.getText().isEmpty() || idPenyewaTF.getText().isEmpty() || tanggalSewaTF.getText().isEmpty() || tanggalKembaliTF.getText().isEmpty() || idBukuTF.getText().isEmpty()){
                    JOptionPane.showMessageDialog(jFrame, "Please Input All Text Field .");
                }
                else {
                    Sewa sewa = new Sewa(0, Integer.parseInt(idAdminTF.getText()), Integer.parseInt(idPenyewaTF.getText()), tanggalSewaTF.getText(),tanggalKembaliTF.getText(), Integer.parseInt(idBukuTF.getText()),1);
                    String response = sewaRepository.insertSewa(sewa);

                    if(response.equals(ErrorConstant.INSERT_SEWA_SUCCESS)){
                        JOptionPane.showMessageDialog(jFrame, "Insert Sewa Success !.");
                    }
                    else if (response.equals(ErrorConstant.INSERT_SEWA_FAILED)){
                        JOptionPane.showMessageDialog(jFrame, "Insert Sewa Failed !.");
                    }

                }
            }
        });
    }

    public JPanel getSewaBuku() {
        return sewaBuku;
    }
}
