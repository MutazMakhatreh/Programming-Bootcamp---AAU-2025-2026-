/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programming.bootcamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Eng. Mutaz Makhatreh
 */

// Class representing a Book
class Book {
    int bookID;
    String title;
    String author;
    boolean isAvailable;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public void displayBookInfo() {
        System.out.println("BookID: " + bookID + ", Title: " + title + ", Author: " + author
                + ", Available: " + isAvailable);
    }

    public void markAsBorrowed() {
        isAvailable = false;
    }

    public void markAsReturned() {
        isAvailable = true;
    }
}

// Class representing a Member
class Member {
    int memberID;
    String name;
    List<Book> borrowedBooks;

    public Member(int memberID, String name) {
        this.memberID = memberID;
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.markAsBorrowed();
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.markAsReturned();
    }

    public void displayMemberInfo() {
        System.out.println("MemberID: " + memberID + ", Name: " + name);
        System.out.println("Borrowed books:");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.title);
        }
    }
}

// Class representing a Librarian
class Librarian {
    int librarianID;
    String name;
    List<BorrowingRecord> managedTransactions;

    public Librarian(int librarianID, String name) {
        this.librarianID = librarianID;
        this.name = name;
        managedTransactions = new ArrayList<>();
    }

    public BorrowingRecord approveBorrowing(Member member, Book book) {
        if (!book.isAvailable) {
            System.out.println("Book " + book.title + " is not available.");
            return null;
        }
        member.borrowBook(book);
        BorrowingRecord record = new BorrowingRecord(book, member, this, new Date());
        managedTransactions.add(record);
        System.out.println("Borrowing approved by " + name + " for " + member.name);
        return record;
    }

    public void approveReturn(Member member, Book book, BorrowingRecord record) {
        member.returnBook(book);
        record.markAsReturned();
        System.out.println("Return approved by " + name + " for " + member.name);
    }

    public void displayLibrarianInfo() {
        System.out.println("LibrarianID: " + librarianID + ", Name: " + name);
    }
}

// Class representing a Borrowing Record
class BorrowingRecord {
    Book book;
    Member member;
    Librarian librarian;
    Date borrowDate;
    Date returnDate;

    public BorrowingRecord(Book book, Member member, Librarian librarian, Date borrowDate) {
        this.book = book;
        this.member = member;
        this.librarian = librarian;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }

    public void markAsReturned() {
        returnDate = new Date();
    }

    public void displayRecord() {
        System.out.println("Book: " + book.title + ", Member: " + member.name + ", Librarian: " 
                + librarian.name + ", Borrowed: " + borrowDate + ", Returned: " + returnDate);
    }
}
public class LibraryManagementSystem {
     public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create some books
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Java Programming", "Author A"));
        books.add(new Book(2, "Data Structures", "Author B"));
        books.add(new Book(3, "Algorithms", "Author C"));

        // Create members
        List<Member> members = new ArrayList<>();
        members.add(new Member(1, "sara"));
        members.add(new Member(2, "Ahmad"));

        // Create librarians
        Librarian librarian = new Librarian(1, "Mr. Ali");

        System.out.println("--- Library System ---");

        // Display available books
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            book.displayBookInfo();
        }

        // Borrowing process
        System.out.print("\nEnter member ID to borrow a book: ");
        int memberID = scanner.nextInt();
        Member member = null;
        for (Member m : members) {
            if (m.memberID==memberID) {
                member = m;
                break;
            }
        }
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        System.out.print("Enter book ID to borrow: ");
        int bookID = scanner.nextInt();
        Book bookToBorrow = null;
        for (Book b : books) {
            if (b.bookID==bookID) {
                bookToBorrow = b;
                break;
            }
        }
        if (bookToBorrow == null) {
            System.out.println("Book not found.");
            return;
        }

        BorrowingRecord record = librarian.approveBorrowing(member, bookToBorrow);
        if (record != null) {
            record.displayRecord();
        }

        // Returning process
        System.out.print("\nEnter book ID to return: ");
        int returnBookID = scanner.nextInt();
        Book bookToReturn = null;
        for (Book b : books) {
            if (b.bookID==returnBookID) {
                bookToReturn = b;
                break;
            }
        }
        if (bookToReturn != null && record != null) {
            librarian.approveReturn(member, bookToReturn, record);
            record.displayRecord();
        }

      
    }
}
