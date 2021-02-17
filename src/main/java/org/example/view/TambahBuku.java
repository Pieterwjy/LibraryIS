package org.example.view;

import org.example.config.DBConnection;
import org.example.constant.ErrorConstant;
import org.example.model.Admin;
import org.example.model.Buku;
import org.example.repository.AdminRepository;
import org.example.repository.BukuRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TambahBuku {
    private JPanel tambahBuku;
    private JTextField isbnTF;
    private JTextField judulBukuTF;
    private JTextField barcodeTF;
    private JTextField banyakBukuTF;
    private JTextField statusTF;
    private JButton tambahButton;
    private JButton kembaliButton;

    private BukuRepository bukuRepository = new BukuRepository(DBConnection.getConnection());

    public TambahBuku(final JFrame jFrame) throws SQLException, ClassNotFoundException {
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
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isbnTF.getText().isEmpty() || judulBukuTF.getText().isEmpty() || barcodeTF.getText().isEmpty() || banyakBukuTF.getText().isEmpty() || statusTF.getText().isEmpty() ){
                    JOptionPane.showMessageDialog(jFrame, "Please Input All Text Field .");
                }
                else {
                    Buku buku = new Buku(isbnTF.getText(), judulBukuTF.getText(), barcodeTF.getText(),Integer.parseInt(banyakBukuTF.getText()), Integer.parseInt(statusTF.getText()));
                    String response = bukuRepository.insertBuku(buku);

                    if(response.equals(ErrorConstant.INSERT_BOOK_SUCCESS)){
                        JOptionPane.showMessageDialog(jFrame, "Book Insert Success !.");
                    }
                    else if (response.equals(ErrorConstant.INSERT_BOOK_FAILED)){
                        JOptionPane.showMessageDialog(jFrame, "Book Insert Failed !.");
                    }

                }
            }
        });
    }
    public JPanel getTambahBuku() {
        return tambahBuku;
    }
}
