package DB;


import java.sql.*;
public class Demo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/text?useSSL=false", "root","utem119y");
            PreparedStatement  stmt2 = conn.prepareStatement("update text.person set Name='aaa' where Name='asd'");
            stmt2.executeUpdate();
            stmt2.close();
           stmt = conn.prepareStatement("SELECT * FROM text.person");
            rs = stmt.executeQuery();
          while (rs.next()) {
                System.out.println(rs.getString("Name"));
                System.out.println(rs.getInt("Age"));
                System.out.println(rs.getBoolean("marriage"));
                System.out.println("----------------------------");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        }
	}
}