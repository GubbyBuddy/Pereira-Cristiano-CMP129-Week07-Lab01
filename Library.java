import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<Book>();
        this.members = new ArrayList<Member>();
    }
    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        }
    }
    public void registerMember(Member member) {
        if (member != null) {
            members.add(member);
        }
    }
    public Book findBookByIsbn(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    public Member findMemberById(String membershipId) {
        for (Member m : members) {
            if (m.getMembershipId().equals(membershipId)) {
                return m;
            }
        }
        return null;
    }

    public boolean borrowBook(String membershipId, String isbn) {
        Member m = findMemberById(membershipId);
        Book b = findBookByIsbn(isbn);

        if (m == null) {
            System.out.println("Transaction Failed: Invalid Member ID " + membershipId);
            return false;
        }
        if (b == null) {
            System.out.println("Transaction Failed: Invalid ISBN " + isbn);
            return false;
        }

        boolean success = m.borrowBook(b);
        if (!success) {
            System.out.println("Transaction Failed: Book is already out on loan");
        }
        return success;
    }
    public boolean returnBook(String membershipId, String isbn) {
        Member m = findMemberById(membershipId);
        Book b = findBookByIsbn(isbn);
        if (m == null || b == null) {
            System.out.println("Transaction Failed: Missing reference identifiers");
            return false;
        }
        return m.returnBook(b);
    }
    public void displayBooks() {
        System.out.println("--- Library Catalog: " + name + " ---");
        for (Book b : books) {
            b.display();
        }
    }

    public void displayMembers() {
        System.out.println("--- Registered Members ---");
        for (Member m : members) {
            m.displayInfo();
        }
    }
}
