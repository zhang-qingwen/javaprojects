package database.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    public static String driver;
    public static String url;
    public static String username;
    public static String password;
    static {
        Properties pt = new Properties();
        try {
            FileInputStream in = new FileInputStream("src/main/resources/db.properties");
            pt.load(in);
            driver = pt.getProperty("driver");
            url = pt.getProperty("url");
            username = pt.getProperty("username");
            password = pt.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("connected successfully!");
        return conn;
    }

    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}