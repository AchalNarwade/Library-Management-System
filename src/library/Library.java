package library;

import java.io.*;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book){
        if(findBook(book.getBookId())!=null){
            System.out.println("Book with ID: " + book.getBookId() + " already exist! cannot add duplicates");
            return;
        }
        books.add(book);
        System.out.println("Book successfully added");
    }

    public void showAllBooks(){
        if(books.isEmpty()){
            System.out.println("No book available in the library.");
        }else {
            for (Book b : books) {
                b.displayBook();
            }
        }
    }

    public Book findBook(int id){
        for(Book b : books){
             if(b.getBookId() == id){
                 return b;
             }
        }
        return null;
    }

    public int getTotalBooks(){
        return books.size();
    }

    public void saveBookToFile(){
        try{
            FileWriter writer = new FileWriter("books.txt");

            for(Book b: books){
                writer.write(b.getBookId() + "," +
                        b.getTitle() + "," +
                        b.getAuthor() + "," +
                        b.isIssue() + "\n"
                );
            }
            writer.close();
            System.out.println("Book saved to the file");
        } catch (IOException e) {
            System.out.println("Error saving books");
        }
    }

    public void loadBookFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("books.txt"));
            String line;

            while ((line = reader.readLine()) != null) {  //reader.readline()-reads one line at a time
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);   //converting saved text into integer
                String title = data[1];
                String author = data[2];
                boolean issued = Boolean.parseBoolean(data[3]);

                Book book = new Book(id, title, author); //creating new book

                //restoring issue status
                if (issued) {
                    book.isIssued();
                }
                //adding rebuilt book in library
                books.add(book);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Library started. No saved data yet.");
        }
    }
}
