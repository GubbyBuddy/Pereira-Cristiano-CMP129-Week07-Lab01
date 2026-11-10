import java.util.ArrayList;

public class Member {
    private String name;
    private String membershipId;
    private ArrayList<Book> borrowedBooks;

    public Member(String name, String membershipId){
        this.name = name;
        this.membershipId = membershipId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getMembershipId(){
        return membershipId;
    }

    public void setMembershipId(String membershipId){
        this.membershipId = membershipId;
    }

    public ArrayList<Book> getBorrowedBooks(){
        return borrowedBooks;
    }

    public boolean borrowBook(Book book){
        if(book.isAvailable()){
            borrowedBooks.add(book);
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book){
        if(book != null && this.borrowedBooks.contains(book)){
            this.borrowedBooks.remove(book);
            book.setAvailable(true);
            System.out.println("book was returned");
            return true;
        } else {
            System.out.println("book was never borrowed");
            return false;
        }
    }

    public void displayInfo(){
        System.out.println(name);
        System.out.println(membershipId);
        
        if(borrowedBooks.isEmpty()){
            System.out.println("No books taken out");
        } else {
            for(int j = 0; j < borrowedBooks.size(); j++){
                System.out.println(borrowedBooks.get(j).getTitle());
            }
        }
    }
}
