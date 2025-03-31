import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Statement;

public class testUpdate
{
    @BeforeEach
    void setup()
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", "password");
            connection.setAutoCommit(false);
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Failed to connect to database", e);
        }
    }


    @Test
    void TestUpdateBrandSuccess()
    {
        String updateSQL = "UPDATE Brand SET brandName = ? WHERE brandID = ?";

    try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", "password"))
    {
        connection.setAutoCommit(false);

    try(PreparedStatement statement = connection.prepareStatement(updateSQL))
    {
        statement.setString(1, "newBrand");
        statement.setString(2, "1");
        int rowsUpdated = statement.executeUpdate();
        assertEquals(1, rowsUpdated);
        System.out.println("Rows updated: " + rowsUpdated);
    }
    connection.rollback();
    }
    catch (SQLException e)
        {
        e.printStackTrace();
        throw new RuntimeException(e);
        }
    }

    @Test
    void TestUpdateBrandFail()
    {
     String updateSQL = "UPDATE Brand SET brandName = ? WHERE brandID = ?";
     try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", ""))
     {
         try(PreparedStatement statement = connection.prepareStatement(updateSQL))
         {
             statement.setString(1, "newBrand");
             statement.setString(2, "invalidBrandID");
             int rowsUpdated = statement.executeUpdate();
             assertEquals(0, rowsUpdated);
             System.out.println("Error: No Rows updated.");
         }
         connection.rollback();
     }
     catch (SQLException e)
     {
         e.printStackTrace();
         throw new RuntimeException(e);
     }
    }
}
