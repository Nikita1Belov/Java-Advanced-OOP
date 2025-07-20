import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("===== TestZipper =====");
            new TestZipper("resources/books.zip").run();

            System.out.println("===== TestZipper2 =====");
            new TestZipper2("resources/books.zip").run();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
