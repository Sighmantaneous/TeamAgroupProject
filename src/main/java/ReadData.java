
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReadData {

    public List<String[]> getAllCustomers(Connection connection) throws SQLException {
        List<String[]> customers = new ArrayList<>();

        String sql = "SELECT * FROM customer";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String[] row = new String[5];
                row[0] = String.valueOf(rs.getInt("ID"));
                row[1] = rs.getString("CustomerName");
                row[2] = rs.getString("CustomerLastName");
                row[3] = rs.getString("CustomerEmail");
                row[4] = rs.getString("CustomerPhone");

                customers.add(row);
            }
        }

        return customers;
    }
    public List<String[]> getAllBrands(Connection connection) throws SQLException {
        List<String[]> brands = new ArrayList<>();

        String sql = "SELECT * FROM brand";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
                 while (rs.next()) {
                     String[] row = new String[2];
                     row[0] = String.valueOf(rs.getInt("ID"));
                     row[1] = rs.getString("BrandName");

                     brands.add(row);
                 }
        }
        return brands;
    }
    public List<String[]> getAllWarehouses(Connection connection) throws SQLException {
        List<String[]> warehouses = new ArrayList<>();

        String sql = "SELECT * FROM warehouse";
        try (Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String[] row = new String[2];
                row[0] = String.valueOf(rs.getInt("ID"));
                row[1] = rs.getString("WarehouseLocation");

                warehouses.add(row);
            }
        }
        return warehouses;
    }
    public List<String[]> getAllCategory(Connection connection) throws SQLException {
        List<String[]> category = new ArrayList<>();

        String sql = "SELECT * FROM category";
        try (Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            String[] row = new String[2];
            row[0] = String.valueOf(rs.getInt("ID"));
            row[1] = rs.getString("CategoryName");

            category.add(row);
            }
        }
        return category;
    }
    public List<String[]> getAllProducts(Connection connection) throws SQLException {
        List<String[]> products = new ArrayList<>();

        String sql = "SELECT * FROM product";
        try (Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {

        String[] row = new String[8];
            row[0] = String.valueOf(rs.getInt("ID"));
            row[1] = rs.getString("ProductName");
            row[2] = rs.getString("Description");
            row[3] = rs.getString("Price");
            row[4] = rs.getString("ProductStock");
            row[5] = rs.getString("BrandID");
            row[6] = rs.getString("WarehouseID");
            row[7] = rs.getString("CategoryID");

            products.add(row);
            }
        }
        return products;
    }
    public List<String[]> getAllOrders(Connection connection) throws SQLException {
        List<String[]> orders = new ArrayList<>();

        String sql = "SELECT * FROM order";
        try (Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {

        String[] row = new String[4];
        row[0] = String.valueOf(rs.getInt("ID"));
        row[1] = rs.getString("OrderDate");
        row[2] = rs.getString("OrderCost");
        row[3] = rs.getString("CustomerID");

        orders.add(row);}
        }
        return orders;
    }
    public List<String[]> getAllAddresses(Connection connection) throws SQLException {
        List<String[]> addresses = new ArrayList<>();

        String sql = "SELECT * FROM adress";
        try (Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String[] row = new String[6];
                row[0] = rs.getString("ID");
                row[1] = rs.getString("customerID");
                row[2] = rs.getString("country");
                row[3] = rs.getString("city");
                row[4] = rs.getString("street");
                row[5] = rs.getString("eircode");

            }
        }
        return addresses;
    }
    public List<String[]> getAllPayments(Connection connection) throws SQLException {
        List<String[]> payments = new ArrayList<>();

        String sql = "SELECT * FROM payment";
        try (Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
        String[] row = new String[5];
        row[0] = String.valueOf(rs.getInt("ID"));
        row[1] = rs.getString("OrderID");
        row[2] = rs.getString("paymentAmount");
        row[3] = rs.getString("paymentDate");
        row[4] = rs.getString("paymentMethod");

        payments.add(row);
            }
        }
        return payments;
    }
}


