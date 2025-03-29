
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
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql2 = "Insert into Brand values(?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql2)) {
            stmt.setInt(1, 5);
            stmt.setString(2, "Test");
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void TestInsertBrandFailure() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "simon", "password");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String BrandFailure = "Insert into Brand values(?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(BrandFailure);
             PreparedStatement stmtFailCase = connection.prepareStatement(BrandFailure)) {
            stmt.setInt(1, 10);
            stmt.setString(2, "Test");
            stmt.executeUpdate();

            stmtFailCase.setInt(1, 10);
            stmtFailCase.setString(2, "TestFailCase");

            assertThrows(SQLIntegrityConstraintViolationException.class, stmtFailCase::executeUpdate,
                    "Inserting a duplicate ID should throw a SQLIntegrityConstraintViolationException");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void TestInsertCategorySuccess() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "simon", "password");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String CategoryTest = "Insert into Category values(?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(CategoryTest)) {
            stmt.setInt(1, 7);
            stmt.setString(2, "TestWindow");
            int changeToCategory = stmt.executeUpdate();
            assertEquals(1, changeToCategory);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void TestInsertCategoryFailure() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "simon", "password");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String CategoryTest = "Insert into Category values(?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(CategoryTest);
             PreparedStatement stmtFailCase = connection.prepareStatement(CategoryTest)) {
            stmt.setInt(1, 10);
            stmt.setString(2, "TestWindow");
            stmt.executeUpdate();

            stmtFailCase.setInt(1, 10);
            stmtFailCase.setString(2, "TestFailWindow");

            assertThrows(SQLIntegrityConstraintViolationException.class, stmtFailCase::executeUpdate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void TestInsertCustomerSuccess() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "simon", "password");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String CustomerTest = "Insert into Customer values(?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(CustomerTest)) {
            stmt.setInt(1, 10);
            stmt.setString(2, "Test1FName");
            stmt.setString(3, "Test1Lname");
            stmt.setString(4, "Test1Email");
            stmt.setString(5, "Test1Phone");
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void TestInsertCustomerFailure() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "simon", "password");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String CustomerFailure = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt1 = connection.prepareStatement(CustomerFailure);
             PreparedStatement stmtFailCase = connection.prepareStatement(CustomerFailure)) {

            stmt1.setInt(1, 6);
            stmt1.setString(2, "Test1FName");
            stmt1.setString(3, "Test1Lname");
            stmt1.setString(4, "Test1Email");
            stmt1.setString(5, "Test1Phone");
            stmt1.executeUpdate();


            stmtFailCase.setInt(1, 6);
            stmtFailCase.setString(2, "DuplicateFName");
            stmtFailCase.setString(3, "DuplicateLname");
            stmtFailCase.setString(4, "DuplicateEmail");
            stmtFailCase.setString(5, "DuplicatePhone");

            assertThrows(SQLIntegrityConstraintViolationException.class, stmtFailCase::executeUpdate,
                    "Duplicate value ");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void TestInsertAddressSuccess() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "simon", "password");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String AddressTest = "INSERT INTO Address VALUES (?,?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(AddressTest)) {
            stmt.setInt(1, 10);
            stmt.setInt(2, 3);
            stmt.setString(3, "IrelandTest");
            stmt.setString(4, "GalwayTest");
            stmt.setString(5, "123 abbystreet");
            stmt.setString(6, "H91e999");
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //TestAddress create fail

    @Test
    void TestInsertAddressFailure() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "simon", "password");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String AddressTest = "INSERT INTO Address VALUES (?,?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(AddressTest);
             PreparedStatement stmtFailCase = connection.prepareStatement(AddressTest)) {
            stmt.setInt(1, 10);
            stmt.setInt(2, 3);
            stmt.setString(3, "IrelandTest");
            stmt.setString(4, "GalwayTest");
            stmt.setString(5, "123 abbystreet");
            stmt.setString(6, "H91e999");
            stmt.executeUpdate();


            stmtFailCase.setInt(1, 10);
            stmtFailCase.setString(2, "3");
            stmtFailCase.setString(3, "FailCountry");
            stmtFailCase.setString(4, "FailCity");
            stmtFailCase.setString(5, "FailStreet");
            stmtFailCase.setString(6, "FailEircode ");


            assertThrows(SQLIntegrityConstraintViolationException.class, stmtFailCase::executeUpdate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //TestOrders create pass
    @Test
    void TestInsertOrdersSuccess() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "simon", "password");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String OrdersTest = "INSERT INTO Orders VALUES (?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(OrdersTest)) {
            stmt.setInt(1, 10);
            stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            stmt.setInt(3, 50);
            stmt.setInt(4, 3);
            stmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //TestOrders create fail'
    @Test
    void TestInsertOrdersFailure() {
        Connection connection = null;


        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "simon", "password");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String OrdersTest = "INSERT INTO Orders VALUES (?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(OrdersTest);
             PreparedStatement stmtFailCase = connection.prepareStatement(OrdersTest)) {
            stmt.setInt(1, 10);
            stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            stmt.setInt(3, 50);
            stmt.setInt(4, 3);
            stmt.executeUpdate();

            stmtFailCase.setInt(1, 10);
            stmtFailCase.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            stmtFailCase.setInt(3, 25);
            stmtFailCase.setInt(4, 3);

            assertThrows(SQLIntegrityConstraintViolationException.class , stmtFailCase::executeUpdate);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        //TestPayments create pass
    @Test
    void TestInsertPaymentsSuccess() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "simon", "password");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String PaymentsTest = "INSERT INTO Payments VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(PaymentsTest)) {

            stmt.setInt(1, 10);
            stmt.setInt(2, 10);
            stmt.setInt(3, 50);
            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            stmt.setString(5, "TestPaymentMethod");
            stmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        //TestPayments create fail
    @Test
    void TestInsertPaymentsFailure() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "simon", "password");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String PaymentsTest = "INSERT INTO Payments VALUES (?,?,?,?,?)";

        try(PreparedStatement stmt = connection.prepareStatement(PaymentsTest);
        PreparedStatement stmtFailCase = connection.prepareStatement(PaymentsTest)){

            stmt.setInt(1, 10);
            stmt.setInt(2, 10);
            stmt.setInt(3, 50);
            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            stmt.setString(5, "TestPaymentMethod");
            stmt.executeUpdate();

            stmtFailCase.setInt(1, 10);
            stmtFailCase.setInt(2, 10);
            stmtFailCase.setInt(3, 50);
            stmtFailCase.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            stmtFailCase.setString(5, "TestFailPaymentMethod");



            assertThrows(SQLIntegrityConstraintViolationException.class , stmtFailCase::executeUpdate);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

        //TestProduct create pass
        //TestProduct create fail

        //TestWareHouse create pass
        //TestWareHouse create fail

}




