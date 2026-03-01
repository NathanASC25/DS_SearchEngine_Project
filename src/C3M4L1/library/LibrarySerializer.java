package C3M4L1.library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
//import C3M4L1.Book;

public class LibrarySerializer {
    // Serialization method to preserve books data
    public void saveLibrary(List<Book> books, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                            // TODO - missing code
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Deserialization method to process binary to text data
    @SuppressWarnings("unchecked")
    public List<Book> loadLibrary(String fileName) {
        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) {

            return null;
        }

        try
                (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            // TODO - missing code
            List<Book> deserialized = (List<Book>) ois.readObject();
            return deserialized;
        }
        catch (EOFException e) {

            System.err.println("The file is empty or corrupted: " + fileName);
            return null;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

