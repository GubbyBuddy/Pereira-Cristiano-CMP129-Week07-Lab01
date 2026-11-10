public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library("Library");

        Book b1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
        Book b2 = new Book("Clean Code", "Robert Martin", "978-0132350884");
        Book b3 = new Book("Design Patterns", "Gang of Four", "978-0201633610");
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        Member m1 = new Member("Alice Smith", "M001");
        Member m2 = new Member("Bob Jones", "M002");
        library.registerMember(m1);
        library.registerMember(m2);
        System.out.println("INITIAL DISPLAY ");
        library.displayBooks();
        System.out.println();
        library.displayMembers();
        System.out.println("\nBEGIN TESTS\n");
        System.out.print("[TEST] Alice borrows: ");
        boolean t1 = library.borrowBook("M001", "978-0132350884");
        if (t1) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.print("[TEST] Bob attempts to borrow  : ");
        boolean t2 = library.borrowBook("M002", "978-0132350884");
        if (!t2) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.print("[TEST] Alice returns : ");
        boolean t3 = library.returnBook("M001", "978-0132350884");
        if (t3) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.print("[TEST] Bob borrows now vailable : ");
        boolean t4 = library.borrowBook("M002", "978-0132350884");
        if (t4) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.print("[TEST] Alice borrows with fake ISBN: ");
        boolean t5 = library.borrowBook("M001", "999-0000000000");
        if (!t5) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.print("[TEST] Fake ID attempts to borrow: ");
        boolean t6 = library.borrowBook("M999", "978-0134685991");
        if (!t6) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("\n FINAL DISPLAY");
        library.displayBooks();
        System.out.println();
        library.displayMembers();
    }
}
