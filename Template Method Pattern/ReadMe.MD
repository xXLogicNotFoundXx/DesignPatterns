# Template Method Pattern
The Template Method defines the steps of an algorithm and allows subclasses to provide the implementation for one or more steps.

It is about inheritance and about encapsulating pieces of algorithms so that subclasses can hook themselves right into a computation in an abstract class.

Lets say you have two receipies for Tea and Coffee (Algorithms)
```
Coffee Recipe :                                 Tea Recipe:           
(1) Boil some water                             (1) Boil some water
(2) Brew coffee in boiling water      !=        (2) Steep tea in boiling water
(3) Pour coffee in cup                          (3) Pour tea in cup
(4) Add sugar and milk                !=        (4) Add lemon
```

Now you can have Beverage class and two subclasses Tea and Coffee.  Beverage would have prepareRecipe(), and methods() for each step in the algorithm. Subclasses Tea and Coffee will implement all these methods including prepareRecipe().

This Will result into : 
1. Coffee and Tea are running the show; they control the algorithm.
2. Code is duplicated across Coffee and Tea.
3. Code changes to the algorithm require opening the subclasses and making multiple changes.
4. Classes are organized in a structure that requires a lot of work to add a new caffeine beverage.
5. Knowledge of the algorithm and how to implement it is distributed over many classes.

![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Template%20Method%20Pattern/Template%20Method%20Pattern.pdf)
