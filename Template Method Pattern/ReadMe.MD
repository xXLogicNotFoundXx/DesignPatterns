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

You can use template method pattern (with hooks if you want) :
![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Template%20Method%20Pattern/img/CoffeeTeaTemplateMethod.png)

**The way we added a template method to abstract class which defines the algorithm and allows subclasses to provide the implementation for one or more steps thats the template Method Pattern!**

![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Template%20Method%20Pattern/img/UMLTemplateMethod.png)


Now lets talk about hooks. **Hooks** are nothing but concrete methods that do nothing by default in abstract class but they are there to have additional conditions for subclasses to implement in an algorithm.\
**What if customer doesnt want additional condiments?**

![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Template%20Method%20Pattern/img/CoffeeTeaWithHook1.png)
![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Template%20Method%20Pattern/img/CoffeeTeaWithHook2.png)

## Use Case 1: Sorting 
![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Template%20Method%20Pattern/img/SortingTemplateMethod.png)

Here we are not extendind Arrays class though os it not like textbook template method pattern.\
Sometimes we have to modify to fit the context and implementation constraints.\
In general, you can’t subclass a Java array and they wanted the sort to be used on all arrays (and each array is a different class). So they defined a static method and deferred the comparison part of he algorithm to the items being sorted.
