Let’s say there is a class named Mortgage, which inherits from the Exception class. This class has a constructor that takes the following parameters: mortgage loan term and principal amount. Then the constructor calls the method Calculate(), which contains the following algorithm:

monthly_installment = principal / loan_term + principal / 240. 

This method operates on the class data using this. and returns a float number as the result for the customer. Before performing the calculation, Calculate() checks the input data. If the loan term in months is invalid (less than 0 or greater than 300) or the principal amount is negative or exceeds the maximum allowed (if such maximum exists), then the method throws an InvalidData() error with the message: "Invalid data, try again."
