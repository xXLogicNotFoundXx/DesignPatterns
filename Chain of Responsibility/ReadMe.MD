## Chain of Responsibility
The chain of responsibility pattern creates a chain of handler objects for a request. This pattern comes under behavioral patterns.

## With the Chain of Responsibility Pattern, you create a chain of objects that examine a request. Each object in turn examines the request and handles it, or passes it on to the next object in the chain.
It doesnt have to handle/pass relation. You can modify in way that every chain object handle the request for example. 
Let say You have a looger and you wan to write logs to File, DB and Console too. You can create a Chain of the loggers and each one can write it to respective places.

Think of it as a Linked List nodes of different child classes and each one handles/passes the request to next object in the chain.

![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Chain%20of%20Responsibility/img/Chain%20of%20Responsibility.png)

### Each object in the chain acts as a handler and has a successor object. If it can handle the request, it does; otherwise, it forwards the request to its successor.

### Chain of Responsibility Benefits
* Decouples the sender of the request and its receivers.
* Simplifies your object because it doesn’t have to know the chain’s structure and keep direct references to its members.
* **Allows you to add or remove responsibilities dynamically by changing the members or order of the chain.**

### Chain of Responsibility Uses and Drawbacks
* Execution of the request isn’t guaranteed; it may fall off the end of the chain if no object handles it (this can be an advantage or a disadvantage).
* Can be hard to observe the runtime characteristics and debug.
