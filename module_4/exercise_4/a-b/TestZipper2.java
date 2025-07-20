import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;

class Book {
    private final Path file;
    private final String bookName;
    private final int lineCount;
    private final List<String> words;

    public Book(Path file, String bookName, int lineCount, List<String> words) {
        this.file = file;
        this.bookName = bookName;
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

}

class TestZipper2 extends Zipper {
    Book[] books = new Book[100];
    int idx = 0;

    TestZipper2(String zipFile) throws IOException {
        super(zipFile);
    }

    @Override
    public void run() throws IOException {
        super.run();

        System.out.printf("""

                Handled %d Books.
                Now we could sort it out a bit.

                """, idx);
    }

    @Override
    protected Handler<Book> createHandler(Path file) {
        return new Handler(file) {
            @Override
            public void handle() throws IOException {
                Book.createFromFile(file);
                idx++;
            }
        };
    }
}
