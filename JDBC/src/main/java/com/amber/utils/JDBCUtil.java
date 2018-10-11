package com.amber.utils;

import java.sql.*;

public class JdbcUtil {

    public static Connection getConnection() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/jdbc_test";
        String username = "root";
        String password = "";
        Connection conn = null;
        //1.注册驱动
        try {
            Class.forName(driver);
            //2.建立连接
           return conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void release(Connection conn, Statement stmt, ResultSet rs ) {
        releaseResultSet(rs);
        releaseStatement(stmt);
        releaseConnection(conn);
    }

    public static void releaseResultSet (ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void releaseStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void releaseConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
