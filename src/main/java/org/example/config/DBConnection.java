package org.example.config;
import org.example.constant.EnvConstant;

import java.sql.*;

public class DBConnection{
    private static Connection connection;

    public static Connection getConnection () throws ClassNotFoundException{
        try {
            Class.forName(EnvConstant.JDBC_DRIVER);
            connection = DriverManager.getConnection(EnvConstant.DB_URL,EnvConstant.USER,EnvConstant.PASSWORD);
            return connection;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public PreparedStatement preparedStatement(String query) throws SQLException{
        return connection.prepareStatement(query);
    }
}