import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Statement;

public class testUpdate
{
    private Connection connection;

    @BeforeEach
    void setup()
    {
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", "password");
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


    @Test
    void TestUpdateCustomerSuccess()
    {
        String updateSQL = "UPDATE Customer SET customerName =? , customerLastName = ? , customerEmail = ?, customerPhone = ? WHERE customerID = ?";

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", "password"))
        {
            connection.setAutoCommit(false);

            try(PreparedStatement statement = connection.prepareStatement(updateSQL))
            {
                statement.setString(1, "newName");
                statement.setString(2, "newLastName");
                statement.setString(3, "newEmail");
                statement.setString(4, "newPhone");
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
    void TestUpdateCustomerFail()
    {
        String updateSQL = "UPDATE Customer SET customerName =? , customerLastName = ? , customerEmail = ?, customerPhone = ? WHERE customerID = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", ""))
        {
            try(PreparedStatement statement = connection.prepareStatement(updateSQL))
            {
                statement.setString(1, "invalidName");
                statement.setString(2, "invalidLastName");
                statement.setString(3, "invalidEmail");
                statement.setString(4, "invalidPhone");
                statement.setString(5, "invalidID");
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



    @Test
    void TestUpdateWarehouseSuccess()
    {
        String updateSQL = "UPDATE Warehouse SET warehouseAddress = ? WHERE warehouseID = ?";

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", "password"))
        {
            connection.setAutoCommit(false);

            try(PreparedStatement statement = connection.prepareStatement(updateSQL))
            {
                statement.setString(1, "newWarehouseAddress");
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
    void TestUpdateWarehouseFail()
    {
        String updateSQL = "UPDATE Warehouse SET warehouseAddress = ? WHERE warehouseID = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", ""))
        {
            try(PreparedStatement statement = connection.prepareStatement(updateSQL))
            {
                statement.setString(1, "invalidWarehouseAddress");
                statement.setString(2, "invalidID");
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



    @Test
    void TestUpdateCategorySuccess()
    {
        String updateSQL = "UPDATE Category SET categoryName = ? WHERE categoryID = ?";

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", "password"))
        {
            connection.setAutoCommit(false);

            try(PreparedStatement statement = connection.prepareStatement(updateSQL))
            {
                statement.setString(1, "newCategory");
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
    void TestUpdateCategoryFail()
    {
        String updateSQL = "UPDATE Category SET  = ? WHERE  = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", ""))
        {
            try(PreparedStatement statement = connection.prepareStatement(updateSQL))
            {
                statement.setString(1, "invalidCategory");
                statement.setString(2, "invalidCategoryID");
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



    @Test
    void TestUpdateProductSuccess()
    {
        String updateSQL = "UPDATE Product SET productName = ?, productDescription = ?, productPrice = ?, productStock = ? WHERE productID = ?";

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", "password"))
        {
            connection.setAutoCommit(false);

            try(PreparedStatement statement = connection.prepareStatement(updateSQL))
            {
                statement.setString(1, "newProductName");
                statement.setString(2, "newProductDescription");
                statement.setString(3, "newProductPrice");
                statement.setString(4, "newProductStock");
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
    void TestUpdateProductFail()
    {
        String updateSQL = "UPDATE Product SET productName = ?, productDescription = ?, productPrice = ?, productStock = ? WHERE productID = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", ""))
        {
            try(PreparedStatement statement = connection.prepareStatement(updateSQL))
            {
                statement.setString(1, "invalidProductName");
                statement.setString(2, "invalidProductDescription");
                statement.setString(3, "invalidProductPrice");
                statement.setString(4, "invalidProductStock");
                statement.setString(5,"invalidProductID");
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


    @Test
    void TestUpdateOrdersSuccess()
    {
        String updateSQL = "UPDATE Orders SET orderDate = ?, orderCost = ? WHERE orderID = ?";

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", "password"))
        {
            connection.setAutoCommit(false);

            try(PreparedStatement statement = connection.prepareStatement(updateSQL))
            {
                statement.setString(1, "newOrderDate");
                statement.setString(2, "newOrderCost");
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
    void TestUpdateOrdersFail()
    {
        String updateSQL = "UPDATE Orders SET orderDate = ?, orderCost = ? WHERE orderID = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", ""))
        {
            try(PreparedStatement statement = connection.prepareStatement(updateSQL))
            {
                statement.setString(1, "invalidOrderDate");
                statement.setString(2, "invalidOrderCost");
                statement.setString(3, "invalidOrderID");
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



    @Test
    void TestUpdateAddressSuccess()
    {
        String updateSQL = "UPDATE Address SET country = ?, city = ?, street = ?, eircode = ? WHERE addressID = ?";

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", "password"))
        {
            connection.setAutoCommit(false);

            try(PreparedStatement statement = connection.prepareStatement(updateSQL))
            {
                statement.setString(1, "newCountry");
                statement.setString(2, "newCity");
                statement.setString(3, "newStreet");
                statement.setString(4, "newEircode");
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
    void TestUpdateAddressFail()
    {
        String updateSQL = "UPDATE Address SET country = ?, city = ?, street = ?, eircode = ? WHERE addressID = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", ""))
        {
            try(PreparedStatement statement = connection.prepareStatement(updateSQL))
            {
                statement.setString(1, "invalidCountry");
                statement.setString(2, "invalidCity");
                statement.setString(3, "invalidStreet");
                statement.setString(4, "invalidEircode");
                statement.setString(5,"invalidID");
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


    @Test
    void TestUpdatePaymentSuccess()
    {
        String updateSQL = "UPDATE Payments SET paymentAmount = ?, paymentDate = ?, paymentMethod = ? WHERE = paymentsID = ?";

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", "password"))
        {
            connection.setAutoCommit(false);

            try(PreparedStatement statement = connection.prepareStatement(updateSQL))
            {
                statement.setString(1, "newPaymentAmount");
                statement.setString(2, "newPaymentDate");
                statement.setString(3,"newPaymentMethod");
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
    void TestUpdatePaymentFail()
    {
        String updateSQL = "UPDATE Payments SET paymentAmount = ?, paymentDate = ?, paymentMethod = ? WHERE = paymentsID = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", ""))
        {
            try(PreparedStatement statement = connection.prepareStatement(updateSQL))
            {
                statement.setString(1, "invalidPaymentAmount");
                statement.setString(2, "invalidPaymentDate");
                statement.setString(3,"invalidPaymentMethod");
                statement.setString(4,"invalidPaymentID");
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
