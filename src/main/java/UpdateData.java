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
            while(!exit)
            {
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
            }
        }
    }
}
