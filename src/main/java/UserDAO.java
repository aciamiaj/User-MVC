import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    String DB_URL = "jdbc:mysql://localhost:3306/w11_jaimaica";
    String USERNAME = "root";
    String PASSWORD = "navarr0Jds1..";

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        return conn;
    }

    public UserModel getUser(String username, String pass) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("SELECT * FROM user WHERE username = ? and pass = ?");
            ps.setString(1, username);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            if (rs.next()) {
                UserModel user = new UserModel();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("pass"));
                return user;
            }

            return null;
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
    }
}
