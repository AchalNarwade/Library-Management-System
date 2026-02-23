package library;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
        System.out.println("Book successfully added");
    }

    public void showAllBooks(){
        for(Book b : books){
            b.displayBook();
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
}
