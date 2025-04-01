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
                System.out.println("1, Address");
                System.out.println("2, Brand");
                System.out.println("3, Category");
                System.out.println("4, Customer");
                System.out.println("5, Orders");
                System.out.println("6, Payments");
                System.out.println("7, Product");
                System.out.println("8, Warehouse");
                System.out.println("9, Exit");
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
                        updateCategory(connection, sc);
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

    public static void updateAddress(Connection connection, Scanner sc)
    {
        System.out.println("Enter Address ID to update");
        int addressID = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter new Country:");
        String newCountry = sc.nextLine();

        System.out.println("Enter new City:");
        String newCity = sc.nextLine();

        System.out.println("Enter new Street:");
        String newStreet = sc.nextLine();

        System.out.println("Enter new Eircode:");
        String newEircode = sc.nextLine();

        String sql = "UPDATE Address SET country = ?, city = ?, street = ?, eircode = ? WHERE AddressID = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, newCountry);
            statement.setString(2, newCity);
            statement.setString(3, newStreet);
            statement.setString(4, newEircode);

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

    public static void updateBrand(Connection connection, Scanner sc)
    {
        System.out.println("Enter Brand ID to update");
        int brandID = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter new Brand Name");
        String newBrandName = sc.nextLine();

        String sql = "UPDATE Brand SET brand_name = ? WHERE brandID = ?";
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

    public static void updateCategory(Connection connection, Scanner sc) {
        System.out.println("Enter Category ID to update");
        int categoryID = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter new Category Name:");
        String newCountry = sc.nextLine();


        String sql = "UPDATE Category SET categoryName = ? WHERE CategoryID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newCategoryName);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Brand updated successfully.");
            } else {
                System.out.println("Error updating brand.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void updateCustomer(Connection connection, Scanner sc)
    {
        System.out.println("Enter Customer ID to update");
        int customerID = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter new Customer Name:");
        String newCustomerName = sc.nextLine();

        System.out.println("Enter new Customer Last Name");
        String newCustomerLastName = sc.nextLine();

        System.out.println("Enter new Customer Email");
        String newCustomerEmail = sc.nextLine();

        System.out.println("Enter new Customer Phone");
        String newCustomerPhone = sc.nextLine();

        String sql = "UPDATE Customer SET customerName = ?, customerLastName = ?, customerEmail = ?, customerPhone = ? WHERE customerID = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1,newCustomerName);
            statement.setString(2, newCustomerLastName);
            statement.setString(3,newCustomerEmail);
            statement.setString(4,newCustomerPhone);

                // do I need to add the reference ID? //

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
