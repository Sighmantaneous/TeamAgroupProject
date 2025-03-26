import java.sql.*;

public class testUpdate
{
    public static void main(String[] args)
    {
     String updateSQL = "UPDATE customer SET email = 'newEmail@example.com' WHERE firstName = ''";

    try(Connection connection = DatabaseUtils.getConnection();
        Statement statement = connection.createStatement())
    {
        int rowsUpdated = statement.executeUpdate(UpdateSQL);
        System.out.println("Rows updated: " + rowsUpdated);
    }
    catch (SQLException e)
        {
        e.printStackTrace();

        }
    }
}
