## Let's create a few classes for this task.
Let's try to encupsulate specific logic in specific classes.

**TicketType**
This class stores only ticket types:

* *SINGLE (for 2-h)*

* *DAY (for 24-h)*

* *MONTH (for 30-d)*

---

**Ticket**

This class is about a ticket. It saves the next varibales:

* *type (from Ticket Type)*
  
* *duration (in milliseconds)*

* *valid (true or false, perhaps bool type)*
  
There is one method:
* *IsValid (return bool).*

The method just returns the valid variable. Valid means that the duration is less than the maximum duration allowed for this ticket type. If the ticket is valid => return true, the opposite => return false.

---
**FoliCard**

This class for Foli's cards. There are next variables:

* *Balance (saldo)*

* *Valid ticket (there is or no)*

There is one method:
* *GetBalance()*
The method returns the card balance.

* *GetTicketData().*
The method returns the valid variable, there is tikets or no. It returns a list of valid tickets.

* *BuyTicket().*
The method to buy new ticket. It returns status: true or false. And can call GetBalance() inside to return the balance.

* *GetValidTicket().*
The method returns a valid ticket. It Can call GetTicketData() inside. It returns a ticket (Ticket class).

* *Load().*
The method allows to amount the card balance. It returns true or false.
