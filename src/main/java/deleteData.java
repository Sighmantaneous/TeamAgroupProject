import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class deleteData {
    public static void main(String[] args) {
        // Database URL, username, and password
        String jdbcURL = "jdbc:mysql://localhost/groupProjectDatabase";
        String dbUser = "root";
        String dbPassword = "password";

        // SQL DELETE query
        String sql = "DELETE FROM Customer WHERE ID = ?";
        Connection connection;

        try {

            Scanner scanner = new Scanner(System.in);

            // Establishing a connection
            connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            boolean exit = true;

            while (exit) {
                System.out.println("Select table to create Table rows:");
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
                int TableSelect = scanner.nextInt();
                scanner.nextLine();

                switch (TableSelect) {

                    case 1:
                        deleteAddress();
                        break;
                    case 2:
                        deleteBrand();
                        break;
                    case 1:
                        deleteCategory();
                        break;
                    case 1:
                        deleteCustomer();
                        break;
                    case 1:
                        deleteOrders();
                        break;
                    case 1:
                        deletePayments();
                        break;
                    case 1:
                        deleteProduct();
                        break;
                    case 1:
                        deleteWarehouse();
                        break;
                    case 1:
                        exit = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


            // Creating a PreparedStatement
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 1); // Set the ID of the record to delete

            // Executing the DELETE operation
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A record was deleted successfully!");
            }

            // Closing the connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCustomer(Connection connection) {

    }
