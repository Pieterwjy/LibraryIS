package org.example.view;

import org.example.config.DBConnection;
import org.example.constant.ErrorConstant;
import org.example.model.Admin;
import org.example.model.Sewa;
import org.example.repository.SewaRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class PengembalianBuku {
    private JPanel pengembalianBuku;
    private JTextField idSewaTF;
    private JButton OKButton;
    private JButton kembaliButton;

    public JPanel getPengembalianBuku() {
        return pengembalianBuku;
    }

    private SewaRepository sewaRepository = new SewaRepository(DBConnection.getConnection());

    public PengembalianBuku(final JFrame jFrame) throws SQLException, ClassNotFoundException {
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
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(idSewaTF.getText().isEmpty() ){
                    JOptionPane.showMessageDialog(jFrame, "Please Input The Text Field .");
                }
                else {
                    Sewa sewa = new Sewa(Integer.parseInt(idSewaTF.getText()));
                    String response = null;
                    try {
                        response = sewaRepository.updateSewa(sewa);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    if(response.equals(ErrorConstant.UPDATE_SEWA_SUCCESS)){
                        JOptionPane.showMessageDialog(jFrame, "Book Return Success !.");
                    }
                    else if (response.equals(ErrorConstant.UPDATE_SEWA_FAILED)){
                        JOptionPane.showMessageDialog(jFrame, "Book Return  Failed !.");
                    }

                }
            }
        });
    }
}
