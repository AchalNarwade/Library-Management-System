package app;

import library.Book;
import library.Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while(true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show total Books");
            System.out.println("6. Exit");

            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Choice");
                sc.nextLine(); //to clear scanner buffer
            }

            switch (choice) {

                case 1:
                    System.out.println("Enter ID: ");
                    int id = 0;
                    try {
                        id = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid ID");
                        sc.nextLine();
                    }
                    sc.nextLine();//Consumes the leftover newline ,Clears the buffer
                    System.out.println("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter Author: ");
                    String author = sc.nextLine();

                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    library.showAllBooks();
                    break;

                case 3:
                    System.out.println("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    Book bookToIssue = library.findBook(issueId);
                    if (bookToIssue != null) {
                        bookToIssue.issueBook();
                    } else {
                        System.out.println("No book found with ID " + issueId);
                    }
                    break;

                case 4:
                    System.out.println("Enter Book ID to return ");
                    int returnId = sc.nextInt();
                    Book bookToReturn = library.findBook(returnId);
                    if (bookToReturn != null) {
                        bookToReturn.returnBook();
                    } else {
                        System.out.println("No book found with ID " + returnId);
                    }
                    break;

                case 5:
                    System.out.println("Total books in the library: " + library.getTotalBooks());
                    break;


                case 6:
                    System.exit(0);
            }
        }
    }
}