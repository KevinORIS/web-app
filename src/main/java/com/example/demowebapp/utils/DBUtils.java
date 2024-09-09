package com.example.demowebapp.utils;

import java.sql.*;

public class DBUtils {

    private static final String URL = "jdbc:mysql://localhost:3306/j1023_db";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql123";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
        try {
            if(conn != null){
                conn.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(rs != null){
                rs.close();
            }
            if(pstmt != null){
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

