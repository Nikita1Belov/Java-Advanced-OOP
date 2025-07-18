**a)** Perhaps the best way is to create an enum class called Scale with the names of the scales: Celsius, Fahrenheit, and Kelvin. Then, create a second class, Temperature, which would have a double value representing the temperature and a scale from Scale. The Temperature class should also have all the methods for conversion, getting and setting the temperature, performing calculations, etc. The calculation method could be implemented based on the scale; the method of calculation would be chosen according to the scale value.
Other implementations might store just one variable for the temperature value without specifying the scale, but this is not recommended because it complicates calculations.

**b)** Probably the best solution is to implement a Disease interface with two fields: name and symptoms (where symptoms could be a list). Each specific disease would implement this interface, having its own name and symptoms.
Other approaches, for example, creating diseases without an interface, may lead to problems with systematization and unification.

**c)** Create a Student class with the following fields: Name, Postal Address, Email Address, Degree Program, and Number of Credits.
Other approaches can lead to semantic issues. For example, if you used a simple list, it would be easy to confuse the meaning of data at each index.

**d)** Create a method studentFilter that sorts the list of students by the Number of Credits and saves this information into a new list, such as graduatedStudents.
It's easier to work with a Student object because this solution preserves semantics.

**e)** An implementation using a Number class could allow modification of the x and y coordinates by calling methods in the Number class. Saving coordinates as int values directly does not allow the data to be mutated, which may be a limitation.
