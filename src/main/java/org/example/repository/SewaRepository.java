package org.example.repository;

import org.example.config.DBConnection;
import org.example.constant.ErrorConstant;
import org.example.model.Buku;
import org.example.model.Sewa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SewaRepository {
    Connection conn;
    DBConnection connection = new DBConnection();

    public SewaRepository(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        conn = connection;
    }

    public List<Sewa> getActiveSewa(){
        List<Sewa> sewaList = new ArrayList<>();
        String query = "SELECT * FROM tblSewa WHERE Status = 1";
        try{
            PreparedStatement preparedStatement = connection.preparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                sewaList.add( new Sewa(
                                Integer.parseInt(resultSet.getString(1)),
                                Integer.parseInt(resultSet.getString(2)),
                                Integer.parseInt(resultSet.getString(3)),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                Integer.parseInt(resultSet.getString(6)),
                                Integer.parseInt(resultSet.getString(7))
                        )
                );
            }
        }
        catch(SQLException e) {
            e.printStackTrace();

        }
        return sewaList;
    }

    public String updateSewa(Sewa sewa) throws SQLException {
        Sewa accountForReturn = new Sewa();
        String query = "UPDATE tblSewa SET Status = 0 WHERE IdSewa = ?";

        try {
            PreparedStatement preparedStatement = connection.preparedStatement(query);
            preparedStatement.setString(1,String.valueOf(sewa.getIdSewa()));

            int updated = preparedStatement.executeUpdate();
            conn.commit();
            if(updated > 0){
                accountForReturn = sewa;
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
            return ErrorConstant.UPDATE_SEWA_FAILED;
        }
        return ErrorConstant.UPDATE_SEWA_SUCCESS;
    }

    public String insertSewa(Sewa sewa){
        Sewa accountForReturn = new Sewa();
        String query = "INSERT INTO tblSewa(IdAdmin,IdPenyewa,TanggalSewa,TanggalJatuhTempo,IdBuku) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.preparedStatement(query);
            preparedStatement.setString(1,String.valueOf(sewa.getIdAdmin()));
            preparedStatement.setString(2,String.valueOf(sewa.getIdPenyewa()));
            preparedStatement.setString(3,sewa.getTanggalSewa());
            preparedStatement.setString(4,sewa.getTanggalJatuhTempo());
            preparedStatement.setString(5,String.valueOf(sewa.getIdBuku()));

            int updated = preparedStatement.executeUpdate();
            conn.commit();
            if(updated > 0){
                accountForReturn = sewa;
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
            return ErrorConstant.INSERT_SEWA_FAILED;
        }
        return ErrorConstant.INSERT_SEWA_SUCCESS;
    }
}
