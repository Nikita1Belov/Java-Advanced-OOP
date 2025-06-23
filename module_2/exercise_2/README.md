**A library customer makes a search query and you want to offer the customer a view that only supports reading the books.**

For customers, I would provide only read functionality in the Book class. Since customers don’t know the internal logic of the library system, they could unintentionally cause errors in the data. Therefore, I would create specific methods like Search() and GiveBook(). The List<Book> or Book[] would be private, and customers would only have read-only access. For instance, it's possible to create a separate class that handles reading the book list and working with it. All the data would be provided through getters.

**Search**
This method would allow searching for a specific book or returning the full list of books if the customer doesn't specify any keywords (such as title, author, publication year, publisher, etc.). The keywords could be passed as a single string, separated by commas. The function would then split the string and try to find matching books (assuming no UI is available). If nothing is found, it would return a message like “Nothing found.” If all copies of a book are borrowed (in case of a physical library), the function would return “The books are out.”

**GiveBook**
This method would let a customer choose a book, mark it as borrowed, and send the borrowing information to the database.

We could go further and implement a registration system for customers, where each customer has to authenticate before borrowing a book. We could also add a return date to be stored in the system.


**Library staff want to permanently edit the information of a specific book.**

The staff could have a dedicated class with read and update access. However, it's still safer to keep all data private to avoid accidental overwrites. Information could be changed through setters and accessed via getters. Staff could correct mistakes using an UpdateInfo() method. If there is a UI, they would simply update the information via the app. If not, they would use a method similar to Search(), entering the current and new book information in a comma-separated string. The function would parse this and update only the changed fields.
