package library;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private boolean isIssued;
    private String borrowerName;

    public Book(int bookId,String title,String author){
        this.bookId = bookId;
        this.title = title;
        this.author  = author;
        this.isIssued = false;
    }
    public void issueBook(String borrowerName){
        if(!isIssued){
            isIssued = true;
            this.borrowerName = borrowerName;     //set borrower name
            System.out.println(title + " issued to: " + borrowerName);
        }else{
            System.out.println(title + " Book already issued to " + borrowerName);
        }
    }
    public void returnBook(){
        if(isIssued){
            isIssued = false;
            System.out.println(title + " returned successfully from: " + borrowerName);
            this.borrowerName = null;   //clear borrower name when returned
        }else{
            System.out.println("This book was not issued, cannot return.");
        }
    }
    public int getBookId(){
        return bookId;
    }

    public boolean isIssued(){
        return isIssued;
    }

    public String getBorrowerName(){
        return borrowerName;
    }
    public void displayBook(){
        String status;
        if(isIssued){
            status = "Issued to: " + borrowerName;
        }else{
            status = "Available";
        }
        System.out.println(
                "\nBook ID : " + bookId +
                "\nTitle   : " + title +
                "\nAuthor  : " + author +
                "\nStatus  : " + status);
    }
}
