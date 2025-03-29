import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {


    public static void main(String[] args) {

        boolean exit = true;

        Scanner scanner = new Scanner(System.in);
        Connection connection;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/groupProjectDatabase", "simon", "password");
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
                        //call Address creator
                        break;
                    case 2:
                        //call Brand creator
                        InsertBrand();
                        break;
                    case 3:
                        //call category creator
                        InsertCategory();
                        break;
                    case 4:
                        //call Customer creator
                        InsertCustomer();
                        break;
                    case 5:
                        //call Order creator
                        break;

                    case 6:
                        //call payments creator
                        break;
                    case 7:
                        //call product creator
                        break;
                    case 8:
                        //call warehouse creator
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
                connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "simon", "password");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            String sql2 = "Insert into Brand values(?,?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql2)) {
                stmt.setInt(1, BrandID);
                stmt.setString(2, BrandName);
                stmt.executeUpdate();
                System.out.println("Inserted ID=" + BrandID + " Name="+ BrandName+ " into Brand.");
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

            CreateCategory(categoryID,CategoryName);
        }
        public static void CreateCategory(int CategoryID, String CategoryName) {

        Connection connection;

            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "simon", "password");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            String Category = "Insert into Category values(?,?)";
            try (PreparedStatement stmt = connection.prepareStatement(Category)) {
                stmt.setInt(1, CategoryID);
                stmt.setString(2, CategoryName);
                stmt.executeUpdate();
                System.out.println("Inserted ID=" + CategoryID + " Name="+ CategoryName+ " into Brand.");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        public static void InsertCustomer(){

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

            CreateCustomer(CustomerID, FirstName, LastName, Email,PhoneNumber);
        }

        public static void CreateCustomer(int CustomerID, String FirstName, String LastName, String Email, String PhoneNumber) {

            Connection connection;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/groupProjectDatabase", "simon", "password");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String sqlCustomer = "Insert into Customer values(?,?,?,?,?)";

            try (PreparedStatement stmt = connection.prepareStatement(sqlCustomer)){
                stmt.setInt(1, CustomerID);
                stmt.setString(2, FirstName);
                stmt.setString(3, LastName);
                stmt.setString(4, Email);
                stmt.setString(5, PhoneNumber);
                stmt.executeUpdate();
                System.out.println("All items entered into Customer.");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }

        //create Address receive method
        //create Address create method

        //create orders receive method
        //create orders create method

        //create payments receive method
        //create payments create method

        //create product receive method
        //create procuct create method

        //create warehouse receive method
        //create warehouse create method



    }


