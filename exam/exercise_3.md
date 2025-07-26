## a)
A good solution is to create a Client record with the following variables: Name (String), Address (String), EmailAddress (String), PurchasedProduct (String), and PurchaseDate (String).
Using a list type leads to problems when accessing data by index, because the list index and the information are not directly connected. And the class structure is redundant.

## b)
Create a method called clientFilter that returns a List<Client> and filters clients using stream.filter() and stream.collect().
Inside the filter, you can apply any criteria. In our case, the filter should return all clients whose purchase date is before January 2023.

## c)
Perhaps the best approach is to create an enum class called Currency, containing the names of the currencies. Then, create a second enum class, Transaction, which would contain transaction types: Deposit, Withdrawal, and Transfer.
Next, create a class called Operation, which uses both Currency and Transaction. This class can have a print() method to display the operation, and a constructor that takes a Transaction type, a Currency type, and an amount (double).
Additionally, the Operation class can include a currency converter and a calculator.
