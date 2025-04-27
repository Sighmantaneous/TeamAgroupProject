import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteData {
    public static void main(String[] args) {
        // Database details
        String jdbcURL = "jdbc:mysql://localhost/groupProjectDatabase";
        String dbUser = "root";
        String dbPassword = "password.";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "root", "password");
            Scanner scanner = new Scanner(System.in);

            boolean exit = true;
            while (exit) {
                System.out.println("Select table to delete a record:");
                System.out.println("1. Address");
                System.out.println("2. Brand");
                System.out.println("3. Category");
                System.out.println("4. Customer");
                System.out.println("5. Orders");
                System.out.println("6. Payments");
                System.out.println("7. Product");
                System.out.println("8. Warehouse");
                System.out.println("9. Exit");
                System.out.print("Enter choice: ");
                int tableSelect = scanner.nextInt();
                scanner.nextLine();

                switch (tableSelect) {
                    case 1 -> deleteRecord(connection, "Address", scanner);
                    case 2 -> deleteRecord(connection, "Brand", scanner);
                    case 3 -> deleteRecord(connection, "Category", scanner);
                    case 4 -> deleteRecord(connection, "Customer", scanner);
                    case 5 -> deleteRecord(connection, "Orders", scanner);
                    case 6 -> deleteRecord(connection, "Payments", scanner);
                    case 7 -> deleteRecord(connection, "Product", scanner);
                    case 8 -> deleteRecord(connection, "Warehouse", scanner);
                    case 9 -> exit = false;
                    default -> System.out.println("Invalid choice. Try again.");
                }
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRecord(Connection connection, String tableName, Scanner scanner) {
        System.out.print("Enter ID to delete from " + tableName + ": ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String sql = "DELETE FROM " + tableName + " WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Record deleted successfully from " + tableName + "!");
            } else {
                System.out.println("No record found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error deleting record from " + tableName);
            e.printStackTrace();
        }
    }


    
}
