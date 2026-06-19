import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LMS lms = new LMS();

        System.out.print("Enter file location: ");
        String filePath = input.nextLine();

        lms.loadFromFile(filePath);

        System.out.println("\nCurrent Patrons:");
        lms.printPatrons();

        int choice;

        do {

            System.out.println("\n===== LMS Menu =====");
            System.out.println("1. Add Patron");
            System.out.println("2. Remove Patron");
            System.out.println("3. Print Patrons");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("ID: ");
                    String id = input.nextLine();

                    System.out.print("Name: ");
                    String name = input.nextLine();

                    System.out.print("Address: ");
                    String address = input.nextLine();

                    System.out.print("Fine Amount: ");
                    double fine = input.nextDouble();
                    input.nextLine();

                    lms.addPatron(
                            new Patron(id, name, address, fine));

                    lms.printPatrons();
                    break;

                case 2:

                    System.out.print("Enter ID to remove: ");
                    String removeId = input.nextLine();

                    lms.removePatron(removeId);
                    lms.printPatrons();
                    break;

                case 3:

                    lms.printPatrons();
                    break;

                case 4:

                    System.out.println("Exiting...");
                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        input.close();
    }
}