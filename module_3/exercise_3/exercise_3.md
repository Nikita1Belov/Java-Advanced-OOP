**This solution consists of several classes and demonstrates the use of inheritance and polymorphism.**

The first class is Exercise3. It serves as the main entry point for running the program. This class includes the methods run and select. The run method keeps the program running until the user decides to stop it. The select method uses a switch-case construction to call the appropriate method. If the user wants to create a figure, the circle and polygon methods instantiate the corresponding classes. This is an example of composition. The user can also create multiple figures and switch between them. The showHelp method provides a list of all available commands.
```java
class Exercise3 {
    Scanner scanner = new Scanner(System.in);
    List<Shape> figure = new ArrayList<>();
    int currentIndex = -1;
    String input;

    void run() {
        System.out.println("Welcome to the GeometryCLI!");
        System.out.println("Commands: polygon, circle, add, show, square, draw, select, help, exit");

        while (true) {
            input = scanner.nextLine().trim();

            switch (input) {
                case "polygon" -> {
                    Polygon polygon = new Polygon();
                    figure.add(polygon);
                    currentIndex++;
                }
                case "circle" -> {
                    Circle circle = new Circle();
                    figure.add(circle);
                    currentIndex++;
                }
                case "show" -> {
                    if (!figure.isEmpty()) {
                        figure.get(currentIndex).show();
                    } else {
                        System.out.println("There are no parameters!");
                    }
                }
                case "square" -> {
                    if (!figure.isEmpty()) {
                        figure.get(currentIndex).square();
                    } else {
                        System.out.println("There are no parameters!");
                    }
                }
                case "add" -> {
                    if (!figure.isEmpty()) {
                        figure.get(currentIndex).add();
                    } else {
                        System.out.println("There are no parameters!");
                    }
                }
                case "draw" -> {
                    if (!figure.isEmpty()) {
                        figure.get(currentIndex).draw();
                    } else {
                        System.out.println("There are no parameters!");
                    }
                }
                case "select" -> select();
                case "help" -> showHelp();
                case "exit" -> {
                    System.out.println("Exit...");
                    return;
                }
                default -> System.out.println("The unknown command. Write command 'help', please.");
            }

        }
    }

    void select() {
        input = scanner.nextLine().trim();
        int buffer = Integer.parseInt(input)-1;
        if (buffer > figure.size() || buffer < 0) {
            System.out.println("The index is incorrect. Choose another value between 0 and "
                    + figure.size()+ ", please.");
        } else {
            currentIndex = Integer.parseInt(input) - 1;
        }
    }

    void showHelp(){
        System.out.println("""
            Commands:
            - add         — add coordinates (write x and y coordinates) for a polygon or add center coordinates and radius for a circle
            - show        — show all points or circle parameters
            - circle      — initialise circle figure
            - polygon     — initialise polygon figure
            - square      — calculate the square
            - draw        — show the figure or a line/lines
            - select      — switch between figures
            - help        — show help menu
            - exit        — exit the program
        """);
    }
}
```

The next classes are Point, which stores the coordinates of a point, and CircleParameters, which inherits from Point and adds a radius. All necessary functionality from Point is included in CircleParameters using super.
``` java
class Point {
    public double x, y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class CircleParameters extends Point{
    double radius;

    CircleParameters(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }
}
```

There is an interface that defines the required methods for any figure:
add – to add points or circle parameters (center coordinates and radius),

draw – to draw the figure (UI method),

square – to calculate the area of the figure,

show – to display all points or parameters.
```java
interface Shape {
    void add();
    void draw();
    void square();
    void show();
}
```

There is a class for creating polygons of any size (triangles, rectangles, etc.). It uses the universal Gauss method to calculate the area of any polygon. This class implements the Shape interface and overrides its methods, demonstrating inheritance and polymorphism.
```java
class Polygon implements Shape {
    double square;
    List<Point> points = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        if (!points.isEmpty()) {
            points.clear();
        }

        String input = "";
        while (!input.equals("stop")) {
            System.out.println("Enter the x- and y-coordinate of the point: (for example: 10 20). Write 'stop' for edning:");

            System.out.print("Point " + (points.size() + 1) + ": ");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("stop")) {
                System.out.println("Writing points has been ended.");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Error! Write down the coordinates across the space or write 'stop' to end");
                return;
            }

            try {
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                points.add(new Point(x, y));
            } catch (NumberFormatException e) {
                System.out.println("Error! Coordinates must be numbers");
            }
        }
    }

    @Override
    public void draw() {
        class DrawPanel extends JPanel {
            final int margin = 100;
            DrawPanel() {
                setPreferredSize(new Dimension(400, 400));
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < points.size() - 1; i++) {
                    Point p1 = points.get(i);
                    Point p2 = points.get(i + 1);
                    int x1 = (int) (margin + p1.x);
                    int y1 = (int) (getHeight() - margin - p1.y);
                    int x2 = (int) (margin + p2.x);
                    int y2 = (int) (getHeight() - margin - p2.y);
                    g.drawLine(x1, y1, x2, y2);
                }
                if (points.size() > 2) {
                    Point pStart = points.get(0);
                    Point pEnd = points.get(points.size() - 1);
                    int x1 = (int) (margin + pEnd.x);
                    int y1 = (int) (getHeight() - margin - pEnd.y);
                    int x2 = (int) (margin + pStart.x);
                    int y2 = (int) (getHeight() - margin - pStart.y);
                    g.drawLine(x1, y1, x2, y2);
                }

                for (Point p : points) {
                    g.fillOval((int) (margin + p.x) - 3, (int) ((getHeight() - margin - p.y) - 3), 6, 6);
                }
            }
        }

        JFrame frame = new JFrame("Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DrawPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void square() {
        if (points.size() > 2) {
            Point[] points2 = points.toArray(new Point[0]);
            // 1. Calculate the center:
            double sumX = 0, sumY = 0;
            for (Point p : points2) {
                sumX += p.x;
                sumY += p.y;
            }

            final double centerX = sumX / points2.length;
            final double centerY = sumY / points2.length;

            // 2. Sorting by polar angle:
            Arrays.sort(points2, (a, b) -> {
                double angleA = Math.atan2(a.y - centerY, a.x - centerX);
                double angleB = Math.atan2(b.y - centerY, b.x - centerX);
                return Double.compare(angleA, angleB);
            });

            int n = points2.length;
            double area = 0;

            for (int i = 0; i < n; i++) {
                Point current = points2[i];
                Point next = points2[(i + 1) % n];
                area += (current.x * next.y) - (next.x * current.y);
            }

            square = Math.abs(area) / 2.0;

            System.out.println("The square is: " + square);
        } else {
            System.out.println("Square doesn't exist for this.");
        }
    }

    @Override
    public void show(){
        System.out.println("\nYour points:");
        for (int i=0; i<points.size(); i++) {
            System.out.println("x" + (i+1) + ": " + points.get(i).x + " ; y" + (i+1) + ": " + points.get(i).y);
        }
    }
}
```

And this class also uses inheritance and polymorphism.
```java
class Circle implements Shape {
    double square;
    CircleParameters parameters;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        System.out.println("Enter the x- and y-coordinate of the center and radius: ");
        String input = scanner.nextLine().trim();
        System.out.println("Writing data has been ended.");

        String[] parts = input.split(" ");
        if (parts.length != 3) {
            System.out.println("Error! Write down the center coordinate the radius across the space");
        }

        try {
            double centerX = Integer.parseInt(parts[0]);
            double centerY = Integer.parseInt(parts[1]);
            double radius = Integer.parseInt(parts[2]);
            parameters = new CircleParameters(centerX, centerY, radius);
        } catch (NumberFormatException e) {
            System.out.println("Error! Coordinate and radius must be numbers");
        }
    }

    @Override
    public void draw() {
        class DrawPanel extends JPanel {
            final int margin = 100;
            DrawPanel() {
                setPreferredSize(new Dimension(400, 400));
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawOval((int) (parameters.x + margin + parameters.radius),
                        (int) (getHeight() - margin - parameters.y - parameters.radius),
                        (int) (2 * parameters.radius), (int) (2 * parameters.radius));

                g.fillOval((int) (margin + parameters.x + 2 * parameters.radius - 3),
                        (int) ((getHeight() - margin - parameters.y - 3)), 6, 6);
            }
        }

        JFrame frame = new JFrame("Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DrawPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void square() {
        double radius = parameters.radius;
        square = Math.PI * radius * radius;
        System.out.println("The square is: " + square);
    }

    @Override
    public void show(){
        System.out.println("\nYour parameters:");
        System.out.println("center x: " + parameters.x + "; center y: " +
                parameters.y + "; radius: " + parameters.radius);
    }
}
```

The full implementation is provided in the Exercise3 file.
