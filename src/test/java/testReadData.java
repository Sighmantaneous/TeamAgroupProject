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
    void setup() {
        myReadData = new ReadData();
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/groupProjectDatabase", "root", "password");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
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
            ;
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
            ;
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
        try {
            List<String[]> warehouses = myReadData.getAllWarehouses(connection);
            Assertions.assertNotNull(warehouses, "warehouse data should not be null");
            Assertions.assertTrue(warehouses.size() > 0, "Expected at least one warehouse in database");
            for (String[] warehouse : warehouses) {
                System.out.printf("ID: %s, Location: %s",
                        warehouse[0], warehouse[1]);
            }
            ;
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

    @Test
    void testAllCategorySuccess() {
        try {
            List<String[]> categories = myReadData.getAllCategory(connection);
            Assertions.assertNotNull(categories, "category data should not be null");
            Assertions.assertTrue(categories.size() > 0, "Expected at least one category in database");
            for (String[] category : categories) {
                System.out.printf("ID: %s, Name: %s",
                        category[0], category[1]);
            }
            ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testAllCategoryFail() {
        assertThrows(SQLException.class, () -> {
            myReadData.getAllCategory(null);
        }, "Expected SQLException");
    }

    @Test
    void testAllProductsSuccess() {
        try {
            List<String[]> products = myReadData.getAllProducts(connection);
            assertNotNull(products, "Product data should not be null");
            assertTrue(products.size() > 0, "Expected at least one product record");
            for (String[] product : products) {
                System.out.printf(
                        "Product ID: %s, Name: %s, Price: %s, Stock: %s, BrandID: %s, CategoryID: %s, WarehouseID: %s%n",
                        product[0], product[1], product[3], product[4], product[5], product[6], product[7]
                );
            }

        } catch (SQLException e) {
            fail("Unexpected SQL exception: " + e.getMessage());
        }
    }

    @Test
    void testAllProductsFail() {
        assertThrows(SQLException.class, () -> {
            myReadData.getAllProducts(null);
        }, "Expected SQLException");
    }

    @Test
    void testAllOrdersSuccess() {
        try {
            List<String[]> orders = myReadData.getAllOrders(connection);
            assertNotNull(orders, "Order data should not be null");
            assertTrue(orders.size() > 0, "Expected at least one order record");
            for (String[] order : orders) {
                System.out.printf(
                        "Order ID: %s, Date: %s, Cost: %s, CustomerID: %s%n",
                        order[0], order[1], order[2], order[3]
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testAllOrdersFail() {
        assertThrows(SQLException.class, () -> {
            myReadData.getAllOrders(null);
        }, "Expected SQLException");
    }

    @Test
    void testAddressSuccess() {
        try {
            List<String[]> addresses = myReadData.getAllAddresses(connection);
            assertNotNull(addresses, "Address data should not be null");
            assertTrue(addresses.size() > 0, "Expected at least one address record");

            for (String[] address : addresses) {
                System.out.printf(
                        "Address ID: %s, C,ustomerID: %s, Country: %s, City: %s Street: %s, Eircode: %s%n",
                        address[0], address[1], address[2], address[3], address[4], address[5]
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testAddressFail() {
        assertThrows(SQLException.class, () -> {
            myReadData.getAllAddresses(null);
        }, "Expected SQLException");
    }
    @Test
    void testPaymentsSuccess() {
        try{
            List<String[]> payments = myReadData.getAllPayments(connection);
            assertNotNull(payments, "Payment data should not be null");
            assertTrue(payments.size() > 0, "Expected at least one payment record");

            for (String[] product : payments) {
                System.out.printf(
                        "Payment ID: %s, OrderID: %s, Amount: %s, Date: %s, Method: %s%n",
                        product[0], product[1], product[2], product[3], product[4]
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testPaymentsFail() {
        assertThrows(SQLException.class, () -> {
            myReadData.getAllProducts(null);
        }, "Expected SQLException");
    }
}



