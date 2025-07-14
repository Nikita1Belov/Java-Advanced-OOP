## a) Explain how inheritance and polymorphism manifest in the following cases. Pay special attention to the different catch branches.

**Inheritance**
Inheritance is realizted in the Problem, the WeirdProblem, the TrickyProblem classes. The Problems extends The Exception. The WeirdProblem and the TrickyProblem extend the Problem.

**Polymorphism**
This mechanism was realizated in the Experiment2 class by exception throwing by using the Problem parent class instead of using two children the WeirdProblem, the TrickyProblem classes. And in main() catch with the Problem exception block is the last, because it's a parent for the WeirdProblem, the TrickyProblem classes. And if it would be the first, otner catch blocks with the WeirdProblem, the TrickyProblem don't work because The Problem class is a parent and its exceptions are more priority.
