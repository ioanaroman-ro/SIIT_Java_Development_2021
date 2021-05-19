package libraryCatalog;

import java.util.List;
import java.util.Scanner;

public class LibraryCatalogMain {
    public static void main(String[] args) {

        Catalog.loadExistingBooks();
        List<Book> books = Catalog.books;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you an employee?(y/n)");
        String choice;
        choice = scanner.nextLine().toLowerCase();

        if (choice.equals("y")) {
            System.out.println("Please enter ID: ");
            String id = scanner.nextLine();
            if (User.checkUser(id)) {
                getUserToChoose(scanner, books);
            }
        } else {
            books = Catalog.books;
            System.out.println("Would you like to see all our available items?(y/n)");
            choice = scanner.nextLine().toLowerCase();
            if (choice.equals("y")) {
                System.out.println("What would you like to borrow?(1. Novel or 2. Artalbum or 3. Show all)");
                int c = scanner.nextInt();
                Catalog.clientChoice(c, books);
            } else {
                if (choice.equals("n")) {
                    System.out.println("Are you looking for something specific?");
                    System.out.println("1. Author.\n2. Name.\n3. Novel type.\n4. Exit.");
                    int c = scanner.nextInt();
                    Catalog.checkAvailability(c, books);
                } else {
                    System.out.println("No valid choice.");
                }
            }
        }
    }

    private static void getUserToChoose(Scanner scanner, List<Book> books) {
        System.out.println("Please \n1. Add Books.\n2. Check all books.\n3. Exit.");
        Integer usersChoice = scanner.nextInt();
        userChoice(usersChoice, books);
    }

    public static void userChoice(Integer usersChoice, List<Book> books) {
        Scanner scanner = new Scanner(System.in);
        switch (usersChoice) {
            case 1 -> {
                Catalog.addNewBook();
                System.out.println("Would you like to continue?(y, n)");
                String cont = scanner.nextLine().toLowerCase();
                if (cont.equals("y")) {
                    getUserToChoose(scanner, books);
                } else {
                    userChoice(3, books);
                }
            }
            case 2 -> Catalog.printAllBooks(books);
            case 3 -> System.out.println("EXIT");
            default -> {
                System.out.println("An Invalid Choice!");
                System.out.println("Repeat your Choice!");
                usersChoice = scanner.nextInt();
                userChoice(usersChoice, books);
            }
        }
    }
}


