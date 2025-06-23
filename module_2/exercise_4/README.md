## H2 Let's create a few classes for this task.
Let's try to incupsulate specific logic in specific classes.

**TicketType**
This class stores only ticket types:

* *SINGLE (for 2-h)*

* *DAY (for 24-h)*

* *MONTH (for 30-d)*

---

**Ticket**

This class about a ticket. It saves the next varibales:

* *type (from Ticket Type)*
  
* *duration (in milliseconds)*

* *valid (true or false, perhaps bool type)*
  
There is one method:
* *IsValid (return bool).*

The method just return the valid variable. If the ticket is valid => return true, the opposite => return false.

---
**FoliCard**

This class for Foli's cards. There are next variables:

* *Balance (saldo)*

* *Valid ticket (there is or no)*

There is one method:
* *GetBalance()*
The method return the card balance.

* *GetTicketData().*
The method return the valid variable, there is tikets or no. It returns a list of valid tickets.

* *BuyTicket().*
The method to buy new ticket. It returns status: true or false. And can call GetBalance() inside to return the balance.

* *GetValidTicket().*
The method return a valid ticket. It Can call GetTicketData() inside. It returns a ticket (Ticket class).

* *Load().*
The method allows to amount the card balance. It returns true or false.
