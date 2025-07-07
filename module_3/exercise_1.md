## a.) What form of inheritance is involved in the following case? Background theory: inheritance and polymorphism.
This is Specialization because LoginScreen is a CommandLineApp. The logic of inheritance here is to get the methods from a parent class. The LoginScreen class extends the CommandLineApp class, and we don't see any @Override annotations or other classes or interfaces being implemented or merged.

## b.) Comment on and evaluate the following code. Why does it work / not work? What are the benefits and drawbacks associated with it? Background theory and context of the task: inheritance and polymorphism.
This code doesn't work because the interface NaturalResource has a public spend method, not a private one. If we try to implement our own private method instead of overriding the public one, we will get an error that the interface method is not implemented.

**Benefits:**
All classes implementing the interface are unified.

Code repetition is avoided.


**Drawbacks**
If our implementation needs to "break the rules" and require a private method, this becomes a problem. We must implement the spend method as public, and inside it we can call our own private method, but this private method must have a different name.

## c.) Comment on and evaluate the following code. Why does it work / not work? What are the benefits and drawbacks.
This code works, because Integer is a subtype of Object.

**Benefits:**
This code allows a covariant return types for overridng methods. And it makes possibly to return a more spesific type.

**Drawbacks**
It's needed to be careful with types in override methods, due to these types must be covariant. For example, we can't return type Object if the inherited method returns Integer, because it isn't covariant types.
