import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Path booksDir = Paths.get("unzippedBooks");
        List<Book> books = new ArrayList<>();

        try (DirectoryStream<Path> files = Files.newDirectoryStream(booksDir, "*.txt")) {
            for (Path file : files) {
                books.add(Book.createFromFile(file));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Order by name");
        books.stream().sorted().forEach(System.out::println);

        System.out.println("\nOrder by line count");
        books.stream().sorted(new SortByLineCount()).forEach(System.out::println);

        System.out.println("\nOrder by unique words");
        books.stream().sorted(new SortByUniqueWordsDesc()).forEach(System.out::println);

        System.out.println("\nOrder by Name and Line Count");
        books.stream().sorted(new SortByNameThenLineCount()).forEach(System.out::println);
    }
}


class SortByLineCount implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
        return Integer.compare(a.getLineCount(), b.getLineCount());
    }
}

// D) by unique word count descending
class SortByUniqueWordsDesc implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
        return Integer.compare(b.getUniqueWordCount(), a.getUniqueWordCount());
    }
}

// E) first by name, then by line count
class SortByNameThenLineCount implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
        int primary = a.getBookName().compareToIgnoreCase(b.getBookName());
        if (primary != 0) return primary;
        return Integer.compare(a.getLineCount(), b.getLineCount());
    }
}


class Book implements Comparable<Book> {
    private final Path file;
    private final String bookName;
    private final int lineCount;
    private final List<String> words;
    private final Set<String> uniqueWords;


    public Book(Path file, String bookName, int lineCount, List<String> words) {
        this.file = file;
        this.bookName = bookName;
        this.lineCount = lineCount;
        this.words = words;
        this.uniqueWords = new HashSet<>(words);
    }

    public Path getFile() {
        return file;
    }

    public String getBookName() {
        return bookName;
    }

    public int getLineCount() {
        return lineCount;
    }

    public List<String> getWords() {
        return words;
    }

    public static Book createFromFile(Path file) throws IOException {
        var lines = Files.readAllLines(file);
        var bookName = lines.isEmpty() ? "Unknown" : lines.get(0);
        var contents = Files.readString(file);
        var regex = Pattern.compile("\\W");
        var words = regex.splitAsStream(contents)
                .filter(s -> !s.isBlank())
                .map(String::toLowerCase)
                .toList();

        return new Book(file, bookName, lines.size(), words);
    }

    public int getUniqueWordCount() {
        return uniqueWords.size();
    }

    @Override
    public int compareTo(Book other) {
        return this.bookName.compareToIgnoreCase(other.bookName);
    }

    @Override
    public String toString() {
        return String.format("Book{name='%s', lines=%d, uniqueWords=%d}", bookName, lineCount, getUniqueWordCount());
    }
}
