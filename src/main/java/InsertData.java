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
                        break;
                    case 4:
                        //call Customer creator
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
                System.out.println("Inserted ID=" + BrandID + " Name="+ BrandName+ " into Brand.");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
           // System.out.println("Inserted " + BrandID + " into Brand.");



        }
    }


