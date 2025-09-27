import java.sql.*;

public class DatabaseConnectivity {
    public static final String URL = "jdbc:mysql://localhost:3306/studentmanagement";
    public  static final String USER = "root";
    public  static final String PASSWORD = "Antarctica@60";

    public static Connection con = null;

    public DatabaseConnectivity() {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ✅ fixed driver
             con=DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("✅ Database connected successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ JDBC Driver not found.");
            e.printStackTrace();
        }

    }

    // ✅ fixed parameter order & added column names
    public void insertion(String name, String contact, String email, String marks, String grade) {

        String query = "INSERT INTO studentinfo(name, contact, email, marks, grade) VALUES(?,?,?,?,?)";
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement smt = con.prepareStatement(query);
            smt.setString(1, name);
            smt.setString(2, contact);
            smt.setString(3, email);
            smt.setString(4, marks);
            smt.setString(5, grade);
            smt.executeUpdate();
            System.out.println("✅ Record inserted successfully.");
        } catch (SQLException e) {
            System.out.println("❌ Error inserting record.");
            e.printStackTrace();
        }
    }

    // ✅ cleanup method
    public void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("🔒 Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
