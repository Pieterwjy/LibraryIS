package org.example.view;

import org.example.config.DBConnection;
import org.example.model.Sewa;
import org.example.repository.SewaRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class PenyewaAktif {
    private JPanel penyewaAktif;
    private JTable aktifTable;
    private JButton kembaliButton;
    private SewaRepository sewaRepository = new SewaRepository(DBConnection.getConnection());

    public PenyewaAktif(final JFrame jFrame) throws SQLException, ClassNotFoundException {
        String headers[] = { "ID Sewa", "ID Admin","ID Penyewa","Tanggal Sewa","Tanggal Jatuh Tempo","ID Buku","Status" };

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(headers);
        aktifTable.setModel(model);

        List<Sewa> sewaList=sewaRepository.getActiveSewa();


        for (int i = 0; i < sewaList.size(); i++) {

            Object idSewa = sewaList.get(i).getIdSewa();
            Object idAdmin =sewaList.get(i).getIdAdmin();
            Object idPenyewa = sewaList.get(i).getIdPenyewa();
            Object tanggalSewa = sewaList.get(i).getTanggalSewa();
            Object tanggalJatuhTempo = sewaList.get(i).getTanggalJatuhTempo();
            Object idBuku = sewaList.get(i).getIdBuku();
            Object status = sewaList.get(i).getStatus();

            Object[] row = { idSewa, idAdmin, idPenyewa,tanggalSewa,tanggalJatuhTempo,idBuku,status};

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

    public JPanel getPenyewaAktif() {
        return penyewaAktif;
    }
}
