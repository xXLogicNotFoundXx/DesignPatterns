## Single Difference beetween Factory Method Pattern and Abstract Factory Pattern is :
* Factory Method Pattern **construct a single object**
* Abstract Factory Pattern **construct multiple objects**

Technically it is very simple but if you think about it, it is like Dependancy Injection. 

## Abstract Factory Pattern
The Abstract Factory Pattern provides an interface for creating **families of related or dependent** objects without specifying their concrete classes.

https://www.youtube.com/watch?v=v-GiuMmsXj4

![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Factory/Abstract%20Factory%20Pattern/img/UMLAbstractFactory1.png)


The point is you have two products ProductA and ProductB and you want to make sure you create these products with some dependacy.
For e.g. You can create ConcreteProductA1 and ConcreteProductB1 but having ConcreteProductA1 & ConcreteProductB2 together doesnt makes sense.

Use Case 1: 
Imagine you have some app and you want to have two themes DarkTheam and LightTheam.\
DarkTheme probably have black background and a white text. It doesnt make sense for DarkTheam to have background as black and text as black too.\
So you can have a factory that returns families of related or dependent objects. ( Background color,  Text style, Text color etc.)

## Another UML of Abstract Factory Pattern :
![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Factory/Abstract%20Factory%20Pattern/img/UMLAbstractFactory.png)

