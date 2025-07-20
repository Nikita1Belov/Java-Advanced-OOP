## a)
The challenge1 uses inhertitance from a superclass (Bird). The challenge2 uses generics, which implements both Winged and Bipedal.

## b)
The challenge1 uses only Bird objects, however the challenge2 uses any objects, which inherites the Winged and the Bipedal interfaces.

## c)
The challeng2 works with the following example, but the challenge2 does not:
```java
class Pterodactyl implements Winged, Bipedal {
    @Override
    public String toString() {
        return "Pterodactyl";
    }
}
```
This isn't a bird, but could walk and fly.

```java
public class Exercise3 {
    public Exercise3() {
        challenge1(new Pterodactyl()); // Not a Bird object, it'll call an compilation error
        challenge2(new Pterodactyl());    // OK for challenge2, because implemetns both required interfaces
    }

    void challenge1(Bird b) {
        System.out.println("In this challenge, we fly and then we walk!");
        b.fly();
        b.walk();
    }

    <X extends Winged & Bipedal> void challenge2(X b) {
        System.out.println("In this challenge, we fly and then we walk!");
        b.fly();
        b.walk();
    }
}
```
