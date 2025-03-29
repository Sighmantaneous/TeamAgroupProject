
import org.junit.jupiter.api.*;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class testInsertData {

    InsertData myInsertData;

    @BeforeEach
    void setup() {

        myInsertData = new InsertData();

    }

    @Test
    void TestInsertBrandSuccess() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "simon", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql2 = "Insert into Brand values(?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql2)) {
            stmt.setInt(1, 1);
            stmt.setString(2, "Nissan");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    }




