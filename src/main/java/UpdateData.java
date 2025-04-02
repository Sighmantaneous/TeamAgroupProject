import java.sql.*;
import java.util.Scanner;


public class UpdateData
{
    public static void main(String[] args)
    {
        boolean exit = false;
        Scanner sc = new Scanner(System.in);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "root", "password"))
        {
            while (!exit)
            {
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

                switch (TableSelect)
                {
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
        catch (SQLException e)
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
        try (PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, newCountry);
            statement.setString(2, newCity);
            statement.setString(3, newStreet);
            statement.setString(4, newEircode);
            statement.setInt(5,)

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0)
            {
                System.out.println("Rows updated successfully.");
            }
            else
            {
                System.out.println("Error updating rows.");
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
        int brandID2 = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter new Brand Name");
        String newBrandName = sc.nextLine();

        String sql = "UPDATE Brand SET brandName = ? WHERE ID = ? " ;
        try (PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, newBrandName);
            statement.setInt(2, brandID2);


            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0)
            {
                System.out.println("Row updated successfully.");
            }
            else
            {
                System.out.println("Error updating row.");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void updateCategory(Connection connection, Scanner sc)
    {
        System.out.println("Enter Category ID to update");
        int categoryID = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter new Category Name:");
        String newCategoryName = sc.nextLine();


        String sql = "UPDATE Category SET categoryName = ? WHERE CategoryID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, newCategoryName);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0)
            {
                System.out.println("Row updated successfully.");
            }
            else
            {
                System.out.println("Error updating row.");
            }
        }
        catch (SQLException e)
        {
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
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newCustomerName);
            statement.setString(2, newCustomerLastName);
            statement.setString(3, newCustomerEmail);
            statement.setString(4, newCustomerPhone);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0)
            {
                System.out.println("Rows updated successfully.");
            }
            else
            {
                System.out.println("Error updating Rows.");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void updateOrders(Connection connection, Scanner sc)
    {
        System.out.println("Enter Order ID to update:");
        int OrderID = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter new Order Date:");
        String newOrderDate = sc.nextLine();

        System.out.println("Enter new Order Cost");
        String newOrderCost = sc.nextLine();

        String sql = "UPDATE Orders SET orderDate = ?, orderCost WHERE OrderID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1, newOrderDate);
            statement.setInt(2, 44); // placeholder order cost

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0)
            {
                System.out.println("Row updated successfully.");
            }
            else
            {
                System.out.println("Error updating row.");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void updatePayments(Connection connection, Scanner sc)
    {
        System.out.println("Enter Payment ID to update:");
        int paymentID = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter new Payment Amount:");
        String newPaymentAmount = sc.nextLine();

        System.out.println("Enter new Payment Date");
        String newPaymentDate = sc.nextLine();

        System.out.println("Enter new Payment Method");
        String newPaymentMethod = sc.nextLine();

        String sql = "UPDATE Payments SET paymentAmount = ?, paymentDate = ?, paymentMethod = ? WHERE paymentID = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1,55);
            statement.setString(2, newPaymentDate);
            statement.setString(3, newPaymentMethod);

            int rowsUpdated = statement.executeUpdate();

            if(rowsUpdated > 0)
            {
                System.out.println("Rows updated successfully.");
            }
            else
            {
                System.out.println("Error updating rows.");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void updateProduct(Connection connection, Scanner sc)
    {
        System.out.println("Enter Product ID to update:");
        int productID = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter new Product Name:");
        String newProductName = sc.nextLine();

        System.out.println("Enter new Product Description");
        String newProductDescription = sc.nextLine();

        System.out.println("Enter new Product Price");
        String newProductPrice = sc.nextLine();

        System.out.println("Enter new Product Stock Amount");
        String newProductStock = sc.nextLine();

        String sql = "UPDATE Product SET productName = ?, productDescription = ?, productPrice = ?, productStock = ? WHERE productID = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1,newProductName);
            statement.setString(2, newProductDescription);
            statement.setInt(3, 60); // random product price for now
            statement.setInt(4, 5); // random product stock for now

            int rowsUpdated = statement.executeUpdate();

            if(rowsUpdated > 0)
            {
                System.out.println("Rows updated successfully.");
            }
            else
            {
                System.out.println("Error updating rows.");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void updateWarehouse(Connection connection, Scanner sc)
    {
        System.out.println("Enter Warehouse ID to update:");
        int warehouseID = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter new Warehouse Address:");
        String newWarehouseAddress = sc.nextLine();


        String sql = "UPDATE Warehouse SET warehouseAddress = ? WHERE warehouseID = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1,newWarehouseAddress);

            int rowsUpdated = statement.executeUpdate();

            if(rowsUpdated > 0)
            {
                System.out.println("Row updated successfully.");
            }
            else
            {
                System.out.println("Error updating row.");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
