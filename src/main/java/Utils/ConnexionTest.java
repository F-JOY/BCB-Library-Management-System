package Utils;

import java.sql.Connection;
import java.sql.SQLException;


public class ConnexionTest {
    public static void main(String[] args) throws SQLException {
    	Connexion co = new Connexion();
        try (Connection conn = co.ConnectBdd()) {
            if (conn != null) {
                System.out.println("Connection successful!");
               
               
            } else {
                System.out.println("Connection is null. Check your configuration.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
