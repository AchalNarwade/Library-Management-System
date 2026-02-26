package library;

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
}
