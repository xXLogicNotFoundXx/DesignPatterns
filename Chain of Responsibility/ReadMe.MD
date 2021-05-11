## Chain of Responsibility
The chain of responsibility pattern creates a chain of handler objects for a request. This pattern comes under behavioral patterns.\
This pattern allows you to add or remove responsibilities dynamically by changing the members or order of the chain.\
https://www.tutorialspoint.com/design_pattern/chain_of_responsibility_pattern.htm

**This pattern is based on inheritance.** If you think about this we need handle() common method which would handle the request and pass to another object. 
Actual handling has to be abstract method that each subclass has to implement. 
![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Chain%20of%20Responsibility/img/Chain%20of%20Responsibility%20Pattern.png)
```
public void logMessage(int level, String message){
      if(this.level <= level){
         write(message);
      }
      
      if(nextLogger !=null){
         nextLogger.logMessage(level, message);
      }
   }
```
### With the Chain of Responsibility Pattern, you create a chain of objects that examine a request. Each object in turn examines the request and handles it, or passes it on to the next object in the chain.
It doesnt have to be handle/pass relationship. You can modify in way that every chain object handle the request for example. 
Let say you wan to write logs to the File, DB and Console too. You can create a Chain of the loggers and each one can write it to respective places.

Think of it as a Linked List nodes of different child classes and each one handles/passes the request to next object in the chain.\
It doesn have to be this simple though. You can have mechanism on which you decide what chain object could handle request & pass  OR  just simply pass it. 

In case of logger we can have log level and depending on the log level appropriate chain object can write that log.  

![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Chain%20of%20Responsibility/img/Chain%20of%20Responsibility.png)

### Each object in the chain acts as a handler and has a successor object. If it can handle the request, it does; otherwise, it forwards the request to its successor.
![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Chain%20of%20Responsibility/img/Email%20Chain%20Handler.png)


### Chain of Responsibility Benefits
* Decouples the sender of the request and its receivers.
* Simplifies your object because it doesn’t have to know the chain’s structure and keep direct references to its members.
* **Allows you to add or remove responsibilities dynamically by changing the members or order of the chain.**

### Chain of Responsibility Uses and Drawbacks
* Execution of the request isn’t guaranteed; it may fall off the end of the chain if no object handles it (this can be an advantage or a disadvantage).
* Can be hard to observe the runtime characteristics and debug.
