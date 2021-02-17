package org.example.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Home {
    private JPanel home;
    private JButton tambahBukuButton;
    private JButton lihatBukuButton;
    private JButton sewaBukuButton;
    private JButton daftarPenyewaAktifButton;
    private JButton pengembalianBukuButton;
    private JButton logoutButton;
    private JButton tambahAdminButton;
    private JButton tambahMemberButton;

    public Home(final JFrame jFrame) {
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n=JOptionPane.showConfirmDialog(null, "Are You Sure ? .","Warning",JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION){
                    jFrame.dispose();
                }
                else if (n == JOptionPane.NO_OPTION){
                }
            }
        });
        tambahAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TambahAdmin tambahAdmin = null;
                try {
                    tambahAdmin = new TambahAdmin(jFrame);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                jFrame.getContentPane().removeAll();
                jFrame.add(tambahAdmin.getTambahAdmin());
                jFrame.repaint();
                jFrame.setVisible(true);
            }
        });
        tambahBukuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TambahBuku tambahBuku = null;
                try {
                    tambahBuku = new TambahBuku(jFrame);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                jFrame.getContentPane().removeAll();
                jFrame.add(tambahBuku.getTambahBuku());
                jFrame.repaint();
                jFrame.setVisible(true);
            }
        });
        tambahMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TambahMember tambahMember = null;
                try {
                    tambahMember = new TambahMember(jFrame);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                jFrame.getContentPane().removeAll();
                jFrame.add(tambahMember.getTambahMember());
                jFrame.repaint();
                jFrame.setVisible(true);
            }
        });
        lihatBukuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LihatBuku lihatBuku = null;
                try {
                    lihatBuku = new LihatBuku(jFrame);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                jFrame.getContentPane().removeAll();
                jFrame.add(lihatBuku.getLihatBuku());
                jFrame.repaint();
                jFrame.setVisible(true);
            }
        });
        sewaBukuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SewaBuku sewaBuku = null;
                try {
                    sewaBuku = new SewaBuku(jFrame);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                jFrame.getContentPane().removeAll();
                jFrame.add(sewaBuku.getSewaBuku());
                jFrame.repaint();
                jFrame.setVisible(true);
            }
        });
        daftarPenyewaAktifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PenyewaAktif penyewaAktif = null;
                try {
                    penyewaAktif = new PenyewaAktif(jFrame);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                jFrame.getContentPane().removeAll();
                jFrame.add(penyewaAktif.getPenyewaAktif());
                jFrame.repaint();
                jFrame.setVisible(true);
            }
        });
        pengembalianBukuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PengembalianBuku pengembalianBuku = null;
                try {
                    pengembalianBuku = new PengembalianBuku(jFrame);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                jFrame.getContentPane().removeAll();
                jFrame.add(pengembalianBuku.getPengembalianBuku());
                jFrame.repaint();
                jFrame.setVisible(true);
            }
        });
    }

    public JPanel getHome() {
        return home;
    }
}
