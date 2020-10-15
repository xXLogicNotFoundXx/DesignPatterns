## The Decorator Pattern 
* The Decorator Pattern  attaches additional responsibilities to an object dynamically. 
* Decorators provide a flexible alternative to subclassing for extending functionality.

Say if you have **Beverage** abstract class and sub classes as **Decaf, Expresso, DarkRoast** ect.\
How would you add condiments to it like **Soya, Milk, Mocha, Cream** etc?\
In the end you should be to be able to calculate the cost of the beverage.\

One way to add classes of DecafSoya, DecafMilk, DecafDarkRoast .... but that would cause **class explosion**.\
One way of doing this would be adding **hasSoy(), hasMilk(), hasMocha(), hasCream()** in **Beverage** class and the cost of the beverage will be calculated depending on all these return values.
* What if a customer wants a double mocha?
* At this point you can see new condiments will force us to add new methods and alter the cost method in the superclass.
* We may have new beverages. For some of these beverages (iced tea?), the condiments may not be appropriate, yet the **Tea** subclass will still inherit methods like hasSoy().

This violates The Open-Closed Principle.

**The Open-Closed Principle - Classes should be open for extension, but closed for modification.**

Our goal is to allow classes to be easily extended to incorporate new behavior without modifying existing code. What do we get if we accomplish this? Designs that are resilient to change and flexible enough to take on new functionality to meet changing requirements.\

While inheritance is powerful, it doesn’t always lead to the most flexible or maintainable designs.\


![UML Decorator](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Decorator%20Pattern/img/UML%20Decorator.png)

