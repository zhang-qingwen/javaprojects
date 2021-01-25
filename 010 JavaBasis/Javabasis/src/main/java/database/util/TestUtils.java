package database.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestUtils {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from idmanager where ID_Type = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "ZCNQ");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getString(2) + "----" + rs.getString("ID_Type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn, pstmt, rs);
        }
    }
}
