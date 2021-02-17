package org.example.repository;

import org.example.config.DBConnection;
import org.example.constant.ErrorConstant;
import org.example.model.Penyewa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PenyewaRepository {
    Connection conn;
    DBConnection connection = new DBConnection();

    public PenyewaRepository(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        conn = connection;
    }

    public String createPenyewa(Penyewa account){
        Penyewa accountForReturn = new Penyewa();
        String query = "INSERT INTO tblPenyewa(NamaPenyewa,AlamatPenyewa,EmailPenyewa,TeleponPenyewa,Status) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.preparedStatement(query);
            preparedStatement.setString(1,account.getNamaPenyewa());
            preparedStatement.setString(2,account.getAlamatPenyewa());
            preparedStatement.setString(3,account.getEmailPenyewa());
            preparedStatement.setString(4,account.getTeleponPenyewa());
            preparedStatement.setString(5,String.valueOf(account.getStatus()));

            int updated = preparedStatement.executeUpdate();
            conn.commit();
            if(updated > 0){
                accountForReturn = account;
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
            return ErrorConstant.CREATE_MEMBER_FAILED;
        }
        return ErrorConstant.CREATE_MEMBER_SUCCESS;
    }

}
