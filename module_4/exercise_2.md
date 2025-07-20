This is implementation the of Book class.
```java
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Book {
    private final Path file;
    private final String bookName;
    private final int lineCount;
    private final List<String> words;

    public Book(Path file, String name, int lineCount, List<String> words) {
        this.file = file;
        this.name = bookName;
        this.lineCount = lineCount;
        this.words = words;
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
}
```

In the Zipper and the Gandler classes are the next changes:
```java
package fi.utu.tech.ooj.exercise4.exercise2;

import fi.utu.tech.ooj.exercise4.exercise1.Zipper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;

public class TestZipper extends Zipper {
    private final List<Book> books = new ArrayList<>();

    public TestZipper(String zipFile) throws IOException {
        super(zipFile);
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    protected Handler createHandler(Path file) {
        return new Handler(file) {
            @Override
            public void handle() throws IOException {
                var regex = Pattern.compile("\\W");
                var contents = Files.readString(file);
                var lines = Files.readAllLines(file);
                var words = regex.splitAsStream(contents).filter(s -> !s.isBlank()).map(String::toLowerCase).toList();
                var uniqueWords = new HashSet<>(words);
                var title = lines.isEmpty() ? "Unknown title" : lines.getFirst();

                books.add(new Book(file, title, lines.size(), uniqueWords.size()));
            }
        };
    }
}
```

And the main realization of required functional is in the Exercise2 class:
```java
package fi.utu.tech.ooj.exercise4.exercise2;

import java.io.IOException;
import java.util.Comparator;

public class Exercise2 {
    runBook() {
        try (var zipper = new TestZipper("books.zip")) {
            zipper.run();

            var books = zipper.getBooks();

            System.out.println("Order(by title");
            books.stream().sorted().forEach(System.out::println);

            System.out.println("Order by line count");
            books.stream()
                    .sorted(Comparator.comparingInt(Book::getLineCount))
                    .forEach(System.out::println);

            System.out.println("Order by unique word count");
            books.stream()
                    .sorted(Comparator.comparingInt(Book::getUniqueWordCount).reversed())
                    .forEach(System.out::println);

            System.out.println("Composite order: title and line count");
            books.stream()
                    .sorted(Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER)
                            .thenComparingInt(Book::getLineCount))
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Something went wrong:");
            e.printStackTrace();
        }
    }
}
```
