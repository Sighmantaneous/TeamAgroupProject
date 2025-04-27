import java.sql.*;
import java.util.Scanner;

public class InsertData {


    public static void main(String[] args) {

        boolean exit = true;

        Scanner scanner = new Scanner(System.in);
        Connection connection;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/groupProjectDatabase", "root", "password");
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
                        InsertAddress();
                        break;
                    case 2:
                        InsertBrand();
                        break;
                    case 3:
                        InsertCategory();
                        break;
                    case 4:
                        InsertCustomer();
                        break;
                    case 5:
                        InsertOrders();
                        break;

                    case 6:
                        InsertPayments();
                        break;
                    case 7:
                        InsertProduct();
                        break;
                    case 8:
                        InsertWareHouse();
                        break;
                    case 9:
                        exit = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

    public static void InsertBrand() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Brand ID: ");
        int BrandID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Brand Name: ");
        String BrandName = scanner.nextLine();

        CreateBrand(BrandID, BrandName);
    }

    public static void CreateBrand(int BrandID, String BrandName) {

        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String Brand = "Insert into Brand values(?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(Brand)) {
            stmt.setInt(1, BrandID);
            stmt.setString(2, BrandName);
            stmt.executeUpdate();
            System.out.println("Inserted ID=" + BrandID + " Name=" + BrandName + " into Brand.");
           } catch (SQLIntegrityConstraintViolationException e) {
                // Handle the exception specifically for integrity constraint violations (e.g., duplicate entries)
                System.err.println("Data already exists.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void InsertCategory() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Category ID: ");
        int categoryID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Category Name: ");
        String CategoryName = scanner.nextLine();

        CreateCategory(categoryID, CategoryName);
    }

    public static void CreateCategory(int CategoryID, String CategoryName) {

        Connection connection;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String Category = "Insert into Category values(?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(Category)) {
            stmt.setInt(1, CategoryID);
            stmt.setString(2, CategoryName);
            stmt.executeUpdate();
            System.out.println("Inserted ID=" + CategoryID + " Name=" + CategoryName + " into Brand.");
        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle the exception specifically for integrity constraint violations (e.g., duplicate entries)
            System.err.println("Data already exists.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void InsertCustomer() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer ID: ");
        int CustomerID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Customer First Name: ");
        String FirstName = scanner.nextLine();
        System.out.println("Enter Customer Last Name: ");
        String LastName = scanner.nextLine();
        System.out.println("Enter Customer Email: ");
        String Email = scanner.nextLine();
        System.out.println("Enter Customer Phone Number: ");
        String PhoneNumber = scanner.nextLine();

        CreateCustomer(CustomerID, FirstName, LastName, Email, PhoneNumber);
    }

    public static void CreateCustomer(int CustomerID, String FirstName, String LastName, String Email, String PhoneNumber) {

        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sqlCustomer = "Insert into Customer values(?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sqlCustomer)) {
            stmt.setInt(1, CustomerID);
            stmt.setString(2, FirstName);
            stmt.setString(3, LastName);
            stmt.setString(4, Email);
            stmt.setString(5, PhoneNumber);
            stmt.executeUpdate();
            System.out.println("All items entered into Customer.");
        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle the exception specifically for integrity constraint violations (e.g., duplicate entries)
            System.err.println("Data already exists.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //create Address receive method
    public static void InsertAddress() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Address ID: ");
        int AddressID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter CustomerID");
        int CustomerID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Country");
        String Country = scanner.nextLine();
        System.out.println("Enter City");
        String City = scanner.nextLine();
        System.out.println("Enter Street");
        String Street = scanner.nextLine();
        System.out.println("Enter Eircode");
        String Eircode = scanner.nextLine();

        CreateAddress(AddressID, CustomerID, Country, City, Street, Eircode);


    }

    public static void CreateAddress(int AddressID, int CustomerID, String Country, String City, String Street, String Eircode) {

        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String Address = "INSERT INTO Address VALUES (?,?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(Address)) {
            stmt.setInt(1, AddressID);
            stmt.setInt(2, CustomerID);
            stmt.setString(3, Country);
            stmt.setString(4, City);
            stmt.setString(5, Street);
            stmt.setString(6, Eircode);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle the exception specifically for integrity constraint violations (e.g., duplicate entries)
            System.err.println("Data already exists.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    //create orders receive method
    public static void InsertOrders() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Order ID: ");
        int OrderID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Order Cost");
        int OrderCost = scanner.nextInt();
        System.out.println("Enter Customer ID");
        int CustomerID = scanner.nextInt();

        CreateOrders(OrderID, OrderCost, CustomerID);
    }

    public static void CreateOrders(int OrderID, int OrderCost, int CustomerID) {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String Orders = "Insert INTO Orders values(?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(Orders)) {
            stmt.setInt(1, OrderID);
            stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            stmt.setInt(3, OrderCost);
            stmt.setInt(4, CustomerID);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle the exception specifically for integrity constraint violations (e.g., duplicate entries)
            System.err.println("Data already exists.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //create payments receive method
    public static void InsertPayments() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Payment ID: ");
        int PaymentID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Order ID");
        int OrderID = scanner.nextInt();
        System.out.println("Payment Amount ");
        int PaymentAmount = scanner.nextInt();
        System.out.println("Payment method");
        String PaymentMethod = scanner.nextLine();
        scanner.nextLine();
        CreatePayments(PaymentID, OrderID, PaymentAmount, PaymentMethod);
    }

    public static void CreatePayments(int PaymentID, int OrderID, int PaymentAmount, String PaymentMethod) {

        Connection connection;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String Payments = "Insert INTO Payments values(?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(Payments)) {

            stmt.setInt(1, PaymentID);
            stmt.setInt(2, OrderID);
            stmt.setInt(3, PaymentAmount);
            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            stmt.setString(5, PaymentMethod);
        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle the exception specifically for integrity constraint violations (e.g., duplicate entries)
            System.err.println("Data already exists.");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void InsertWareHouse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Warehouse ID: ");
        int WarehouseID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Warehouse Address");
        String WarehouseAddress = scanner.nextLine();

        CreateWareHouse(WarehouseID, WarehouseAddress);


    }

    public static void CreateWareHouse(int WarehouseID, String WarehouseAddress) {
        Connection connection;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String Warehouses = "Insert INTO Warehouse values(?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(Warehouses)) {
            stmt.setInt(1, WarehouseID);
            stmt.setString(2, WarehouseAddress);
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle the exception specifically for integrity constraint violations (e.g., duplicate entries)
            System.err.println("Data already exists.");

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }

    public static void InsertProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Product ID: ");
        int ProductID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Product Name: ");
        String ProductName = scanner.nextLine();
        System.out.println("Enter Product Description: ");
        String ProductDescription = scanner.nextLine();
        System.out.println("Enter Product Price: ");
        int ProductPrice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Product Quantity: ");
        int ProductQuantity = scanner.nextInt();
        System.out.println("Enter Product BrandID: ");
        int ProductBrandID = scanner.nextInt();
        System.out.println("Enter Product CategoryID: ");
        int ProductCategoryID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter WarehouseID ");
        int WarehouseID = scanner.nextInt();
        scanner.nextLine();

        CreateProduct(ProductID, ProductName, ProductDescription, ProductPrice, ProductQuantity, ProductBrandID, ProductCategoryID, WarehouseID);

    }

    public static void CreateProduct(int ProductID, String ProductName, String ProductDescription, int ProductPrice, int ProductQuantity, int ProductBrandID, int ProductCategoryID, int WarehouseID) {
        Connection connection;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "root", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String Products = "INSERT INTO Product VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(Products);) {

            stmt.setInt(1,ProductID );
            stmt.setString(2, ProductName);
            stmt.setString(3, ProductDescription);
            stmt.setInt(4, ProductPrice);
            stmt.setInt(5, ProductQuantity );
            stmt.setInt(6, ProductBrandID );
            stmt.setInt(7, ProductCategoryID);
            stmt.setInt(8,WarehouseID );
            stmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle the exception specifically for integrity constraint violations (e.g., duplicate entries)
            System.err.println("Data already exists.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}





