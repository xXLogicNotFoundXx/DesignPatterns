# Factory Method Pattern
## The Factory Method Pattern defines an interface(or an abstract class) for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses. 

* This pattern is a framework in a way that it encapsulates product knowledge into each creator.

Instead of whole lot of classes and instantiating these objects.\
We can encapsulate the instantiating so that we can make it uniform across all the places.\

lets say we have **Pizza** product and whole lot of concrete products like **CheezePizza, PepperoniPizaa** etc.\
we can easily handle that with simple factory(statci factory) programming idiom.\

Now, lets say you want to open up franchise and for quality control of your operations, you want to have same quality method of baking, boxing pizzas.\
However, you want to offer different regional style of pizzas in different stores like store in NY and Chicago.
So that would create **NYStyleCheesePizza, NYStylePepperoniPizza ... and ChicagoStyleCheesePizza, ChicagoStylePepperoniPizza ...**

![UML Pizza Factory Method Pattern](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Factory/Factory%20Method%20Pattern/img/UMLPizzaFactoryMethod.png)
