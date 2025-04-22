import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class testReadData {

    private Connection connection;

    ReadData myReadData;

    @BeforeEach
    void setup()
    {
        myReadData = new ReadData();
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/groupProjectDatabase", "root", "password");
            connection.setAutoCommit(false);
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Failed to connect to database", e);
        }
    }



}
