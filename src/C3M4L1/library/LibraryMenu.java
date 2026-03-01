package C3M4L1.library;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//import UserInteractionLogger;
//import C3M4L1.Book;

public class LibraryMenu {
    private Library library;
    private UserInteractionLogger logger = new UserInteractionLogger();
    private LibrarySerializer serializer = new LibrarySerializer();  // Added serializer

    public LibraryMenu(Library library) {
        this.library = library;

        // Load the library data when the program starts
        List<Book> books = serializer.loadLibrary("src/resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully.");
        } else {
            System.out.println("No saved library found. Loading default books.");
            library.loadBooks("src/resources/data/books.txt");
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // TODO - missing code
            System.out.print("\n=== Main Menu ===\n\n");
            System.out.print("\n1. View All Books");
            System.out.print("\n2. Sort Books by Title");
            System.out.print("\n3. Sort Books by Author");
            System.out.print("\n4. Sort Books by Year");
            System.out.print("\n5. Search for a Book by keyword");
            System.out.print("\n6. Exit");
            System.out.print("\n\nYour Choice: ");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    library.viewAllBooks();
                    break;
                case 2:
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getTitle));
                    library.viewAllBooks();
                    break;
                case 3:
                    SortUtil.insertionSort(library.getBooks(), Comparator.comparing(Book::getAuthor));
                    library.viewAllBooks();
                    break;
                case 4:
                    SortUtil.quickSort(library.getBooks(), Comparator.comparing(Book::getPublicationYear), 0, library.getBooks().size() - 1);
                    library.viewAllBooks();
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.print("\nEnter a search term to find your book: ");
                    String keyword = scanner.nextLine();
                    Book book = library.searchBookByKeyword(keyword);
                    if (book != null) {
                        System.out.print("\nBook found: " + book + "\n");
                    }
                    else {
                        System.out.print("\nBook not found.\n");
                    }
                    break;
                case 6:
                    System.out.print("\nProgram ending.\n");
                    return;
                default:
                    System.out.print("\nInvalid input");
            }
        }
    }

}
