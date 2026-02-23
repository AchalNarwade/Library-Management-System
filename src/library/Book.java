package library;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private boolean isIssued;
    private int idCounter = 100;

    public Book(int bookId,String title,String author){
        this.bookId = idCounter++;
        this.title = title;
        this.author  = author;
        this.isIssued = false;
    }
    public void issueBook(){
        if(!isIssued){
            isIssued = true;
            System.out.println("Book Issued successfully!");
        }else{
            System.out.println("Book already issued.");
        }
    }
    public void returnBook(){
        isIssued = false;
        System.out.println("Book returned successfully.");
    }
    public int getBookId(){
        return bookId;
    }
    public void displayBook(){
        System.out.println(bookId + " | " + title + " | " + author + " | Issued: " + isIssued);
    }
}
