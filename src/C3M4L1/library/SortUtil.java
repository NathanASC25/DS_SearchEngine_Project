package C3M4L1.library;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//import C3M4L1.Book;

public class SortUtil {

    public static void bubbleSort(List<Book> books, Comparator<Book> comparator) {
        // TODO - missing code
        int n = books.size();
        boolean swapped;
        for (int index = 0; index < books.size() - 1; index += 1) {
            swapped = false;
            for (int index2 = 0; index2 < n - 1 - index; index2 += 1) {
                if (comparator.compare(books.get(index2), books.get(index2 + 1)) >= 0) {
                    Book temp = books.get(index2 + 1);
                    books.set(index2 + 1, books.get(index2));
                    books.set(index2, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void insertionSort(List<Book> books, Comparator<Book> comparator) {
        for (int i = 1; i < books.size(); i++) {
            Book key = books.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(books.get(j), key) > 0) {
                books.set(j + 1, books.get(j));
                j = j - 1;
            }
            books.set(j + 1, key);
        }
    }

    public static void quickSort(List<Book> books, Comparator<Book> comparator, int low, int high) {
        if (low < high) {
            int pi = partition(books, comparator, low, high);
            quickSort(books, comparator, low, pi - 1);
            quickSort(books, comparator, pi + 1, high);
        }
    }

    private static int partition(List<Book> books, Comparator<Book> comparator, int low, int high) {
        Book pivot = books.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(books.get(j), pivot) <= 0) {
                i++;
                Collections.swap(books, i, j);
            }
        }
        Collections.swap(books, i + 1, high);
        return i + 1;
    }
}
