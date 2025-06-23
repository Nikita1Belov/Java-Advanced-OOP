**1) Task: What is the value of the variable result at the end of the program when the variable nums refers to the array [1, 2] accepted by the routine avg?**

avg return 1.0 because its length is more than 0, but the result would be 1.0 (not 1.5) due to type rounding. To return 1.5 it's needed a type '(float)' after 'return' key word.

without '(float)':
return sum / nums.length; => 1.0

with '(float)':
return (float) sum / nums.length; => 1.5


**2) What about when the array is empty? Why?**

If the array is empty avg throws the EmptyArray error because the exception block is added in the code:

if (nums == null || nums.length == 0)
        throw new EmptyArray();
