## The Singleton Pattern ensures a class has only one instance, and provides a global point of access to it.



Singleton code is hard to get right.(Multithreading)
```
public class Singleton {
  private static Singleton uniqueInstance;      // static instance 
  
  private Singleton() {} // Doesnt allow to create an object outside of the class 
  
  // Making it thread safe with synchronized
  // static method -  global point of access to it
  public static synchronized Singleton getInstance() {  
    if (uniqueInstance == null) {
      uniqueInstance = new Singleton(); 
    }
    return uniqueInstance; 
  }
}
```
* Sinchronized on getInstance is expensive operation. 
* You can move Sinchronized under if block where uniqueInstance == null. So that way synchronized is used only once when the object is first time created. 
* https://www.geeksforgeeks.org/volatile-keyword-in-java/
```
public class Singleton {
  // The volatile keyword ensures that multiple threads handle the uniqueInstance variable 
  // correctly when it is being initialized to the Singleton instance.
  private volatile static Singleton uniqueInstance;
  
  private Singleton() {}
  
  public static Singleton getInstance() { 
    if (uniqueInstance == null) {
      synchronized (Singleton.class) { 
        if (uniqueInstance == null) {
          uniqueInstance = new Singleton(); 
        }
      } 
    }
    return uniqueInstance; 
  }
}
```

* We can rely on the JVM to create the unique instance of the Singleton when the class is loaded. 
* The JVM guarantees that the instance will be created before any thread accesses the static uniqueInstance variable.
```
public class Singleton {
  // Go ahead and create an instance of Singleton in a static initializer. This code is guaranteed to be thread safe!
  private static Singleton uniqueInstance = new Singleton(); 
  
  private Singleton() {}
  
  public static Singleton getInstance() { 
    return uniqueInstance;
  } 
}
```


There are other problems that comes with this implementation:
* Serialization and deserialization
* Reflection

https://medium.com/@dulajra/java-singletons-using-enum-type-the-best-method-for-making-singletons-in-java-6101048f4f31
