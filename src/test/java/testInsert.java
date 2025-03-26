
import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class testInsert {

    InsertData myInsertData;

    @BeforeEach
    void setup(){

        myInsertData = new InsertData();

    }

    @Test
    void  TestInsertDataSuccess() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/database", "simon", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

     /*   String sql2 = "Insert into Brand values(?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql2)) {
            stmt.setInt(1, 1);
            stmt.setString(2, "Nissan");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
*/
    }

    @Test
    void  TestInsertDataFail() {
        
    }

}


