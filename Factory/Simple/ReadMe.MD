
# Simple Factory(Static Factory) is not a pattern.

The Simple Factory isn’t actually a Design Pattern; it’s more of a programming idiom.
Simple Factory is where you create a class and use (Common Logic OR Conditions) to create different objects.

Defining a simple factory as a static method is a common technique and is often called a static factory.\
Why use a static method? Because you don’t need to instantiate an object to make use of the create method.

For eg 1:\
In ASE, PasswordManagementFoctory.createPasswordManagement() returns an object of PasswordManagement.\
Depending on SSO setting we either return PasswordManagementSSOImpl or PasswordManagementImpl object.\
PasswordManagementSSOImp doesnt do anything related to password bcz SSO is on.

For eg 2:\
You have **Pizza** Product and Concrete products are **CheesePizza, PepperoniPizza**.\
Then You have **PizzaStoreFactory** and static method **Pizza CreatePizza(Type t);**. (Type is Cheeze or Pepperoni)\
Depending on the type provided you return CheesePizza OR PepperoniPizza.

For eg 3:\
In chain of responsibility pattern. It is better to have static factory method where we create all object and link them in chain. 
[Sample](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Chain%20of%20Responsibility/Logger/ChainPatternDemo.java)
