# Facade Pattern
I feel like Facade isn’t actually a Design Pattern; it’s more of a programming idiom.

## The Facade Pattern provides a unified interface to a set of interfaces in a subsytem. Facade defines a higher- level interface that makes the subsystem easier to use.
* To use the Facade Pattern, we create a class that simplifies and unifies a set of more
complex classes that belong to some subsystem. Unlike a lot of patterns, Facade is fairly straightforward; there are no mind bending abstractions to get your head around. But that doesn’t make it any less powerful: the Facade Pattern allows us to avoid tight coupling between clients and subsystems

## Intent :
The most important things to remember about a pattern is its intent. This definition tells us loud and clear that the purpose of the facade it to make a subsystem easier to use through a simplified interface.

### Design Principle
* Principle of Least Knowledge - talk only to your immediate friends.

This principle prevents us from creating designs that have a large number of classes coupled together so that changes in one part of the system cascade to other parts. When you build a lot of dependencies between many classes, you are building a fragile system that will be costly to maintain and complex for others to understand.

![UML Facade](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Facade/img/UMLFacade.png)

## Use Case 1:
In fusion when we create a user we create a user in DB, then in LDAP and then we send the notification to the user.\
We can simply create a UsersFacade class that calls these operations in its CreateUser().

## Adaptor
Converts the interface of a class into another interface client expects. Lets classes work together that couldn't have otherwise bcz of incompatible interfaces. 

## Facade 
Provides a unified interface to a set of interfaces in a subsytem. Facade defines a higher- level interface that makes the subsystem easier to use.


