import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = true;

        while (exit) {
            System.out.println("Welcome to Aodh's Auto Parts Database");
            System.out.println("Please select a CRUD operation:");
            System.out.println("1. Create Items");
            System.out.println("2. Delete Items");
            System.out.println("3. Update Items");
            System.out.println("4. Search Items");
            System.out.println("5. Exit");

            int CRUDselect = scanner.nextInt();
            switch (CRUDselect) {

                case 1:
                    System.out.println("You have entered create function");
                    InsertData.main(args);
                    break;


                case 5:
                    exit = false;
                    System.out.println("Good-Bye");
                    break;
                default:
                    System.out.println("Invalid entry try again");
                    break;

            }



        }
    }



}
