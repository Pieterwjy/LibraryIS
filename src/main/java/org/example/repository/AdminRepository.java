package org.example.repository;

import org.example.config.DBConnection;
import org.example.constant.ErrorConstant;
import org.example.model.Admin;
import org.example.util.SecurityUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AdminRepository {
    Connection conn;
    DBConnection connection = new DBConnection();

    public AdminRepository(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        conn = connection;
    }

    public String createAdmin(Admin account) {
        Admin accountForReturn = new Admin();
        String query = "INSERT INTO tblAdmin(NamaAdmin,Password,AlamatAdmin,EmailAdmin,TeleponAdmin) values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.preparedStatement(query);
            preparedStatement.setString(1,String.valueOf(account.getNamaAdmin()));
            preparedStatement.setString(2,SecurityUtils.passwordEncode(account.getPassword()));
            preparedStatement.setString(3,account.getAlamatAdmin());
            preparedStatement.setString(4,account.getEmailAdmin());
            preparedStatement.setString(5,account.getTeleponAdmin());
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
            return ErrorConstant.CREATE_ACCOUNT_FAILED;
        }
        return ErrorConstant.CREATE_ACCOUNT_SUCCESS;
    }

    public List<Admin> FindAccountByUserName(String UserName){
        List<Admin> accountList = new ArrayList<>();
        String query = "SELECT * FROM tblAdmin Where NamaAdmin = ?";
        try{
            PreparedStatement preparedStatement = connection.preparedStatement(query);
            preparedStatement.setString(1,UserName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                accountList.add( new Admin(
                                Integer.parseInt(resultSet.getString(1)),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                Integer.parseInt(resultSet.getString(7))
                                )
                );
            }
        }
        catch(SQLException e) {
            e.printStackTrace();

        }
        return accountList;
    }

    public String Login(String UserName,String Password) throws SQLException{
        try{
            Admin forCheck = FindAccountByUserName(UserName).get(0);
            if(forCheck.getNamaAdmin().equals(UserName)){
                if(SecurityUtils.verifyPassword(Password,forCheck.getPassword())){
                    return ErrorConstant.CREDENTIAL_VALID;
                } else{
                    return ErrorConstant.CREDENTIAL_INVALID;
                }
            }
            return ErrorConstant.CREDENTIAL_INVALID;
        } catch (IndexOutOfBoundsException exception){
            return ErrorConstant.CREDENTIAL_INVALID;
        }
    }

}
