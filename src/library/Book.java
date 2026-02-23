package library;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int bookId,String title,String author){
        this.bookId = bookId;
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
        if(isIssued){
            isIssued = false;
            System.out.println("Book returned successfully");
        }else{
            System.out.println("This book was not issued, cannot return.");
        }
    }
    public int getBookId(){
        return bookId;
    }
    public void displayBook(){
        System.out.println(bookId + " | " + title + " | " + author + " | Issued: " + isIssued);
    }
}
