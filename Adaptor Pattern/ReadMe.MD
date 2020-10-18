### If it walks like a duck and quacks like a duck, then it  **might be a turkey wrapped with a duck adapter**.

## The Adapter Pattern converts the interface of a class into another interface the clients expect. Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces.

Four confusing patterns are : 
* Adaptor
* Facade
* Proxy 
* Decorator 

You have to consistently look them up to keep them aparat. 

#### Adaptor
Adaptor Pattern is making two interfaces that are not compatible, compatible. 

#### Facade
Taking bunch of complext interation and creating a Facade that you can use. 

#### Proxy
We place a proxy instead of calling original object. Reasons could be security/caching. 

#### Decorator
Is adding behaviour to some particular object. Without opening up that object and chaning it. 

## For Adptor Pattern 
* The intention is not to change the underlying behaviour of any object OR add beahviour OR anything like that. 
* You adapt something and blindly pass on the request. Adaptors do not consist any intelligent logic, it simply pass on the request to adptee. 

## Adptor Pattern 
* Adaptor must implement Target interface.
* Adaptor should have a constructor method with an adaptee object as a parameter. (That is aggregation [adaptee can exist without adaptor]).
* Thats it.


![UML Adaptor](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Adaptor%20Pattern/img/UMLAdaptor.png)

