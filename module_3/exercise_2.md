## a) Explain how inheritance and polymorphism manifest in the following cases. Pay special attention to the different catch branches.

**Inheritance**
Inheritance is realizted in Problem, WeirdProblem, TrickyProblem classes. Problems extends Exception. WeirdProblem and TrickyProblem extend Problem.

**Polymorphism**
Polymorphism is implemented in the Experiment2 class by throwing exceptions using the Problem parent class instead of the two child classes, WeirdProblem and TrickyProblem. In the main() method, the catch block for the Problem exception is placed last because it is the parent class of both WeirdProblem and TrickyProblem. If it were placed first, the other catch blocks for the child exceptions would never be reached, as exceptions of the parent class type would be caught first.

## b) Compare the following reuse methods (Printer1 and Printer2). What is each one about? How do they differ in their operating principles? How do the different methods support, for example, changing the decoration style?
**Printer1 and Printer2**
`Printer1` implements the `Printer` interface and must implement all of its methods. It demonstrates * *inheritance and polymorphism*. Inheritance is shown through extending the `Fancy` class, while polymorphism is shown by overriding methods from the `Printer` interface.

`Printer2` is an example of * *composition*. It uses composition by including an instance of another class (most likely a `Printer`) and delegating the behavior to it. This is realizated here:
```java
private final Decorator decorator = generateDecorator();

Decorator generateDecorator() {
  return new Fancy();
}
```

## The previous Printer functionality needs to be extended in the Printer3 class so that instead of the previous decoration (decorate), the decoration adds the previously defined decoration to the beginning and end of the string, along with the characters --. What kind of implementation would this be?
So that the decoration adds the existing decoration to both the beginning and the end of the string with `--` characters, it's only needed to modify the `decorate` method in the `Printer2` class:
```java
    @Override
    public String decorate(String input) {
        return "--" + decorator.decorate(input) + "--";
    }
```

## How would your solution differ if the number of -- characters used for decoration was not 2 per side but was read from a method described in the Decorator interface? What if it was in the Printer interface?
The implementation could look like this:
```java
interface Decorator {
    String decorate(String input);
    int getSize();
}

interface Printer {
    void print(String s);
    void run();
}

class Fancy implements Decorator {
    @Override
    public String decorate(String input) {
        return "== " + input + " ==";
    }

    @Override
    public int getSize(){return 10;}
}

class Printer3 implements Decorator, Printer {
    private final Decorator decorator =
            generateDecorator();

    Decorator generateDecorator() {
        return new Fancy();
    }

    @Override
    public String decorate(String input) {
        int size = getSize();
        String symbols = "";
        for (int i=0; i<size; i++) {
            symbols = symbols + "-";
        }
        return symbols + decorator.decorate(input) + symbols;
    }

    @Override
    public int getSize(){
        return decorator.getSize();
    }

    @Override
    public void print(String s) {
        System.out.println(s);
    }

    @Override
    public void run() {
        print(decorate("test"));
    }
}


class Main {
    public static void main(String[] args){
        new Printer3().run();
    }
}
```
