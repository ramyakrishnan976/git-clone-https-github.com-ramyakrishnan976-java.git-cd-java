import java.util.Scanner;
public class fine{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        double totalFine = 0;
        int choice;
            System.out.println("\n--- Fine Selection Menu ---");
            System.out.println("1. Not wearing ID (Rs 150)");
            System.out.println("2. Not wearing shoes (Rs 250)");
            System.out.println("3. Casual leave taken (Rs 10/day > 5 days)");
            System.out.println("4. Not returning Library book (Rs 20/day)");
            System.out.println("5. Breakage of Lab item (Rs 10,000)");
            System.out.println("6. Generate Bill and Exit");	
       	    do {
            System.out.print("Enter mistake type (1-6): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of attempts: ");
                    totalFine += sc.nextInt() * 150;
                    break;
                case 2:
                    System.out.print("Enter number of attempts: ");
                    totalFine += sc.nextInt() * 250;
                    break;
                case 3:
    System.out.print("Enter total days of leave: ");
    int days = sc.nextInt();
    if (days > 5) {
        totalFine += (days * 10);
    }
	        if (totalFine > 50) {
            System.out.println("STATUS       : WARNING MESSAGE FOR SUSPENSION");
        }
    break;                case 4:
                    System.out.print("Enter number of books: ");
                    int books = sc.nextInt();
                    System.out.print("Enter days overdue: ");
                    int overdue = sc.nextInt();
                    totalFine += (books * overdue * 20);
                    break;
                case 5:
                    System.out.print("Enter number of items broken: ");
                    totalFine += sc.nextInt() * 10000;
                    break;
                case 6:
                    System.out.println("Generating Fine List...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        System.out.println("\n======= INDIVIDUAL FINE LIST =======");
        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);
        System.out.println("Total Fine   : Rs " + totalFine);
        sc.close();
    }
}
