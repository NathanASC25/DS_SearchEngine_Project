package C3M4L1.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import C3M4L1.Book;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void loadBooks(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
               //  TODO - missing code
                String title = line.substring(0, line.indexOf(","));
                line = line.substring(line.indexOf(",") + 1);
                String author = line.substring(0, line.indexOf(","));
                line = line.substring(line.indexOf(",") + 1);
                int publicationYear = Integer.parseInt(line);
                Book extractedBook = new Book(title, author, publicationYear);
                books.add(extractedBook);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBookByKeyword(String keyword) {
        // TODO missing code
        keyword = keyword.toLowerCase();
        for (Book book : books) {
            boolean condition1 = keyword.equals(book.getTitle());
            boolean condition2 = keyword.equals(book.getAuthor());
            boolean condition3 = keyword.equals(String.valueOf(book.getPublicationYear()));
            if (condition1 || condition2 || condition3) {
                return book;
            }
        }
        return null;
    }


    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}
