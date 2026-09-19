import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL="jdbc:mysql://localhost:3306/employee_management";
    private static final String USER="root";
    private static final String PASSWORD="your_PASSWORD";
    public static Connection getConnection() throws SQLException{
        return 
        DriverManager.getConnection(URL,USER,PASSWORD);
    }
    public static void main(String[]args){
        try{
            Connection connection=getConnection();
            System.out.println("database connected successfully!");
            connection.close();
        }catch(SQLException e){
            System.out.println("database connection failed!");
            e.printStackTrace();
        }
    }
    
}
