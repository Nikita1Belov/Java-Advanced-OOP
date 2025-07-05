## Let’s say there is a class named Mortgage.

It has 2 privat variables, a few methods and one contsructor:

**Contsructor**

There are two private variables: principal (double) and loanTerm (int), which are initialized in the constructor.

**Caclulate**

Thus method is called after creating an object of the Mortgage class. And this method calls other class methods for validation before calculation starting. All these methods reurn boolean values. The Calculate uses an if statement with the AND operator to check the result of these validation methods. If the data is valid, the method calculates the monthly installment, returns it, and displays the message:
"The monthly installment is ..."
If the data is not valid, the method returns without performing the calculation.

*Checking methods*

**IsPrincipleValid**

This method returns true (boolean) if the principle is correct. If it's invalid, it returns false. If the principle is less than 0, it shows the message "The principle can't be negative" and return false. If it's more than maximum, it shows "The principle is too big" with false returning.

**IsLoanTermCorrect**

This method is similar to the IsPrincipleValid method, but it checks the loanTerm. If the loan term is more than 300, it returns false and shows the message "The loan term can't be more than 300 months". And if the loan term is negative, it shows "The loan tern can't be negative" and returns false.
