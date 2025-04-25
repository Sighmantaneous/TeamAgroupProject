
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
}

