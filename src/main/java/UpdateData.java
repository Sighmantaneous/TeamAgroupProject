import java.sql.*;
import java.util.Scanner;


public class UpdateData
{
    public static void main(String[] args)
    {
        boolean exit = false;
        Scanner sc = new Scanner(System.in);

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "james", "password"))
        {
            while(!exit) {
                System.out.println("Select table to update");
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
                int TableSelect = sc.nextInt();
                sc.nextLine();

                switch (TableSelect) {
                    case 1:
                        updateAddress(connection, sc);
                        break;

                    case 2:
                        updateBrand(connection, sc);
                        break;

                    case 3:
                        updateCateory(connection, sc);
                        break;

                    case 4:
                        updateCustomer(connection, sc);
                        break;

                    case 5:
                        updateOrders(connection, sc);
                        break;

                    case 6:
                        updatePayments(connection, sc);
                        break;

                    case 7:
                        updateProduct(connection, sc);
                        break;

                    case 8:
                        updateWarehouse(connection, sc);
                        break;

                    case 9:
                        exit = true;
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void updateBrand(Connection connection, Scanner sc)
    {
        System.out.println("Enter Brand ID to update");
        int brandID = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter new Brand Name");
        String newBrandName = sc.nextLine();

        String sql = "UPDATE brands SET brand_name = ? WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, newBrandName);
            statement.setInt(2,brandID);
            int rowsUpdated = statement.executeUpdate();

            if(rowsUpdated > 0)
            {
                System.out.println("Brand updated successfully.");
            }
            else
            {
                System.out.println("Error updating brand.");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
