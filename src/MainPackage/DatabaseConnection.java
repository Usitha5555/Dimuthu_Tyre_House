
package MainPackage;
import java.sql.*;
/**
 *
 * @author sinxdell
 */
public class DatabaseConnection {
//     private static DatabaseConnection con;
    
//    public static DatabaseConnection getConnection() throws ClassNotFoundException, SQLException{
//        
//        if ( con == null){
//                con = new DatabaseConnection();
//        }
//   
//          Class.forName("com.mysql.jdbc.Driver");
//         con = (DatabaseConnection) DriverManager.getConnection("jdbc:mysql://localhost/nibm_lms", "root", "");
//        return con;
//    }

    public DatabaseConnection() throws ClassNotFoundException,SQLException{
        Connection  con = null;
          Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/nibm_lms", "root", "");
    }
 
}
