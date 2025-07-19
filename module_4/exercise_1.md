## a)-b)
### Zipper
#### abstract public class Zipper
This class defines a template of behavior but doesn’t implement all functionality. It allows reusing common logic and delegates specific details to child classes.
An interface wouldn't be suitable here because interfaces can't define constructors and (until Java 8+) couldn’t contain implemented methods. An abstract class is the best fit for this reusable yet extensible behavior.

#### interface AutoCloseable
This interface allows the class to be used in try-with-resources blocks. It guarantees that the close() method will be called automatically, which simplifies and secures temporary file management.

#### private final Class<?> resolver = Main.class;
This field is used to locate resources, such as the zip file. It is declared private because it is an internal detail of the implementation and doesn’t need to be exposed externally.

#### protected abstract static class Handler
This is a nested static abstract class. Abstract means it must be implemented in a subclass. Protected makes it accessible to child classes of Zipper. Static means it doesn't depend on an instance of the outer class (Zipper), which makes sense because it only processes a Path and doesn’t need Zipper’s internal state.

### TestZipper
##### class TestZipper
This is a concrete subclass of Zipper where the abstract Handler is implemented. It demonstrates how Zipper can be extended and customized to handle different kinds of files.

### Exercise1
##### public class Exercise1
This is the entry point of the exercise. It creates a TestZipper instance and runs the unzipping process. The class is public so the JVM can access and run it.

## c)
The temporary directory exists only as long as the Zipper object exists. It is created in the constructor and automatically deleted when close() is called (either manually or via try-with-resources). This design encapsulates the directory's lifecycle entirely within the Zipper class. Other classes don’t directly manage or interact with this temporary directory.

## d)
The signature protected abstract static class Handler indicates that:
- The class is abstract, so it must be subclassed.
- It’s protected, meaning it’s intended to be used only within Zipper or its subclasses.
- It’s static, meaning it doesn't rely on an instance of the outer Zipper class. This is appropriate here because a Handler only needs the Path to the file it's processing — not the entire Zipper instance.
