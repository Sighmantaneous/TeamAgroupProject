import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


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
    @Test
    void testAllCustomersSuccess() {
        try {
            List<String[]> customers = myReadData.getAllCustomers(connection);

            Assertions.assertNotNull(customers, "Customer data should not be null");
            Assertions.assertTrue(customers.size() > 0, "Expected at least one customer in database");
            for (String[] customer : customers) {
                System.out.printf("ID: %s, Name: %s %s, Email: %s, Phone: %s%n",
                        customer[0], customer[1], customer[2], customer[3], customer[4]);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    @Test
    void testAllCustomersFail() {
        assertThrows(SQLException.class, () -> {
            myReadData.getAllCustomers(null);
        }, "Expected SQLException");
    }

    @Test
    void testAllBrandsSuccess() {
        try {
            List<String[]> brands = myReadData.getAllBrands(connection);

            Assertions.assertNotNull(brands, "brand data should not be null");
            Assertions.assertTrue(brands.size() > 0, "Expected at least one brand in database");
            for (String[] brand : brands) {
                System.out.printf("ID: %s, Name: %s",
                        brand[0], brand[1]);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    @Test
    void testAllBrandsFail() {
        assertThrows(SQLException.class, () -> {
            myReadData.getAllBrands(null);
        }, "Expected SQLException");
    }
    @Test
    void testAllWarehousesSuccess() {
        try{
        List<String[]> warehouses = myReadData.getAllWarehouses(connection);
        Assertions.assertNotNull(warehouses, "warehouse data should not be null");
        Assertions.assertTrue(warehouses.size() > 0, "Expected at least one warehouse in database");
        for (String[] warehouse : warehouses) {
            System.out.printf("ID: %s, Location: %s",
                    warehouse[0], warehouse[1]);
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testAllWarehousesFail() {
        assertThrows(SQLException.class, () -> {
            myReadData.getAllWarehouses(null);
        }, "Expected SQLException");
    }
}
