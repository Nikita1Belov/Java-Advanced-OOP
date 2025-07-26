## a)
**There is exception inheritance:**
```java
abstract class AIException extends Exception {}
class DataProcessingError extends AIException {}
class ModelTrainingError extends AIException {}
```
This hierarchy allows handling both specific exceptions (DataProcessingError, ModelTrainingError) and their common parent AIException, which itself inherits from the base Java Exception class. This demonstrates classical inheritance in exception handling.

**There is polymorphism:**
```java
    var pipeline1 = new AIPipeline();
    var pipeline2 = new AIPipeline2();

    try {
        pipeline1.run();
        pipeline2.run();
    }
    catch (DataProcessingError dp) {}
    catch (ModelTrainingError mt) {}
    catch (AIException ae) {}
```
In the try block, the run() method is called on two different objects: pipeline1 and pipeline2. Both have a method with the same name (run()), but they belong to different classes and may behave differently. This demonstrates method-level polymorphism — one method name, different implementations in different classes.
Another example of polymorphism is in the exception handling — exception polymorphism. The catch blocks handle exceptions in order from more specific (DataProcessingError, ModelTrainingError) to more general (AIException). This order is required because a more general exception (like AIException) would otherwise catch all exceptions of its subclasses, making the more specific catch blocks unreachable.

## b)
Yes, it works, because Java allows method overriding even when the return type differs, as long as the overridden method returns a more specific type (called covariant return type).

However, this implementation is not ideal, because:
 - It violates the Liskov Substitution Principle: CurrencyConverter and SpecificCurrencyConverter are not interchangeable. The subclass completely ignores the currency parameter and applies a fixed multiplier instead of using proper conversion logic. Also, the base class returns Object, while the subclass returns Double, which can lead to inconsistent behavior.
 - Hardcoding currency logic (inside the switch) is not scalable or maintainable. Adding or updating currencies would require modifying the method, which violates good design practices.
 - Different return types can cause confusion: returning Object in the base class forces the user to cast the result to Double when using CurrencyConverter, which is error-prone and unnecessary.
