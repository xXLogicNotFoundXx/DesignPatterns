# Factory Method Pattern
### The Factory Method Pattern defines an interface(or an abstract class) for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses. 
### In my opinion, factory method pattern provides multiple concrete factories that create instances of Concrete products that inherit from the same Abstract product.

* This pattern is a framework in a way that it encapsulates product knowledge into each creator.

Instead of whole lot of classes and instantiating these objects.\
We can encapsulate the instantiating so that we can make it uniform across all the places.\
It will be stupid to create encapsulation around “new SomeClass()” but imagine if we need some post processing before we instantiate an object.\

lets say we have **Pizza** product and whole lot of concrete products like **CheezePizza, PepperoniPizaa** etc.\
we can easily handle that with simple factory(statci factory) programming idiom.\

Now, lets say you want to open up franchise and for quality control of your operations, you want to have same quality method of baking, boxing pizzas. However, you want to offer different regional style of pizzas in different stores like store in NY and Chicago.\
So that would create **NYStyleCheesePizza, NYStylePepperoniPizza ... and ChicagoStyleCheesePizza, ChicagoStylePepperoniPizza ...**

![UML Pizza Factory Method Pattern](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Factory/Factory%20Method%20Pattern/img/UMLPizzaFactoryMethod.png)

```
   PizzaStore nyStore = new NYPizzaStore();
   Pizza pizza = nyStore.orderPizza("cheese"); // orderPizza() is defined in PizzaStore which calls createdPizza ( in this case it is NY pizza creation)
   System.out.println("Ethan ordered a " + pizza.getName() + "\n");
   
   PizzaStore chicagoStore = new ChicagoPizzaStore();
   pizza = chicagoStore.orderPizza("cheese"); // orderPizza() is defined in PizzaStore which calls createdPizza ( in this case it is chicagoStore pizza creation)
   System.out.println("Joel ordered a " + pizza.getName() + "\n");
```

BTW, 
* You can define a default factory method to produce some concrete product.\
* Then you always have a means of creating products even without the need of subclass creators.\
* Here, you can have default definition of createPizza() in PizzaStore class which would return simple pizzas like CheezePizza, PepperoniPizaa.

However, 
* The Factory Method Pattern is useful even if you’ve only got **one concrete creator** because you are decoupling the implementation of the product from its use. 
* If you add additional products or change a product’s implementation, it will not affect your Creator (because the Creator is not tightly coupled to any ConcreteProduct).
* And that is why in Factory Method Pattern UML diagram there is at least one Concrete Creator. 

Note:
* Creator and its subclasses are always independent of the Product and Product subclasses and its use.

### Factory Method Pattern UML
![UML Factory Method Pattern](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Factory/Factory%20Method%20Pattern/img/UMLFactoryMethod.png)


