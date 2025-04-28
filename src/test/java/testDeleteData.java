import org.junit.jupiter.api.*;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;


public class testDeleteData {


    private Connection connection;

    @BeforeEach
    void setup() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "root", "EmrePassword24.");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to database", e);
        }
    }

    @Test
    void testDeleteSuccess() {

        String sql = "DELETE FROM Customer WHERE ID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            stmt.setInt(1, 8);
            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException();
        }

        
    }



    @Test
    void testDeleteFailure() {

        String sql = "DELETE FROM Customer WHERE ID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            stmt.setInt(1, 20);
            int rowsAffected = stmt.executeUpdate();

            assertEquals(0, rowsAffected, "Entered ID could not be found");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }
}
