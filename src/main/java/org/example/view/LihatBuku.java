package org.example.view;

import org.example.config.DBConnection;
import org.example.model.Buku;
import org.example.repository.BukuRepository;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class LihatBuku {
    private JPanel lihatBuku;
    private JTable bukuTable;
    private JButton kembaliButton;
    private BukuRepository bukuRepository = new BukuRepository(DBConnection.getConnection());

    public LihatBuku(final JFrame jFrame) throws SQLException, ClassNotFoundException {
        String headers[] = { "ID Buku", "ISBN","Judul","Barcode","Jumlah Stok","Status" };

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(headers);
        bukuTable.setModel(model);

        List<Buku> bukuList=bukuRepository.getAllBuku();


        for (int i = 0; i < bukuList.size(); i++) {

            Object idBuku = bukuList.get(i).getIdBuku();
            Object isbn =bukuList.get(i).getIsbn();
            Object judul = bukuList.get(i).getJudul();
            Object barcode = bukuList.get(i).getBarcode();
            Object jumlahStok = bukuList.get(i).getJumlahStok();
            Object status = bukuList.get(i).getStatus();

            Object[] row = { idBuku, isbn, judul,barcode,jumlahStok,status};

            model.addRow(row);
        }
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

    public JPanel getLihatBuku() {
        return lihatBuku;
    }
}
