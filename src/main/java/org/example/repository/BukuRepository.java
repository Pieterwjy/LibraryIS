package org.example.repository;

import org.example.config.DBConnection;
import org.example.constant.ErrorConstant;
import org.example.model.Admin;
import org.example.model.Buku;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BukuRepository {
    Connection conn;
    DBConnection connection = new DBConnection();

    public BukuRepository(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        conn = connection;
    }

    public String insertBuku(Buku buku) {
        Buku bukuForReturn = new Buku();
        String query = "INSERT INTO tblBuku(ISBN,Judul,Barcode,JumlahStok,Status) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.preparedStatement(query);
            preparedStatement.setString(1,buku.getIsbn());
            preparedStatement.setString(2,buku.getJudul());
            preparedStatement.setString(3,buku.getBarcode());
            preparedStatement.setString(4,String.valueOf(buku.getJumlahStok()));
            preparedStatement.setString(5,String.valueOf(buku.getStatus()));
            int updated = preparedStatement.executeUpdate();
            conn.commit();
            if(updated > 0){
                bukuForReturn = buku;
            }
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(ErrorConstant.SQL_ROLLBACK);
            try{
                if(conn !=null){
                    conn.rollback();
                }
            } catch (SQLException e1){
                e1.printStackTrace();
            }
            return ErrorConstant.INSERT_BOOK_FAILED;
        }
        return ErrorConstant.INSERT_BOOK_SUCCESS;
    }

    public List<Buku> getAllBuku(){
        List<Buku> bukuList = new ArrayList<>();
        String query = "SELECT IdBuku,ISBN,Judul,Barcode,JumlahStok,Status FROM tblBuku";
        try{
            PreparedStatement preparedStatement = connection.preparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                bukuList.add( new Buku(
                                Integer.parseInt(resultSet.getString(1)),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                Integer.parseInt(resultSet.getString(5)),
                                Integer.parseInt(resultSet.getString(6))
                        )
                );
            }
        }
        catch(SQLException e) {
            e.printStackTrace();

        }
        return bukuList;
    }

}
