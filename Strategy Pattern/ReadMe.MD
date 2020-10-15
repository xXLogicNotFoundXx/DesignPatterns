https://www.youtube.com/watch?v=v9ejT8FO-7I

![UML Strategy](http://www.programmingwithwolfgang.com/wp-content/uploads/2018/01/Strategy.jpg)

* Its about composition rather than inheritance. 
* The strategy pattern is a family of ALGORITHMS, incapusalets each algorithm and makes them interchangable. 
* Strategy lets the algorithm vary independently from clients that use it.
* Enables selecting an algorithm at runtime.
* The decision about which algorithm to use until runtime allows the calling code to be more flexible and reusable.

For eg:
* If you have "List" implementation then rather than implementing sorting algorithm in the List. 
* We can inject sorting strategy(algo) into the list. And sorting strategy can be independent from the list.

Another thing : 
* In inheritance sharing algo/implementation downwards is easy. 
* However, sharing code horizontally is difficult between the classes. 
     
lets say:  We have a Duck class and other subclasses of Duck. 

Class Duck
* Quack()
* Fly()
* Display()

Now we have WildDuck, CityDucks, MountainDuck and RubberDuck classes. 
* WildDuck, CityDucks shares the same Fly() beahvior. MountainDuck, RubberDuck shares the same Fly() beahvior.
* WildDuck, MountainDuck shares the same Display() beahvior. CityDuck, RubberDuck shares the same Display() beahvior. 

Now at this point you can see lot of code will be copy pasted. You can build different heirarchy but you will end up in a situation where the beahviour needed to be 
shared horizontally between the classes. So you either have duplicate code or find another solution. 


The solution for this is not to have any subclasses. We can have Duck class and 3 interface obejects in it. 
* IFlyBehavior, IQuackBehavior, IDisplayBehavior 

Each of these interafaces can have concrete classes which implements these beahviors like: 
* For IFlyBehavior concrete classes JetFly, HopFly which implements the fly beahvior.
* For IQuackBehavior concrete classes SimpleQuack, LoudQuack which implements the Quack beahvior.
* For IDisplayBehavior concrete classes TextDisplay, GUIDisplay which implements the Display beahvior.



```
Class Duck{
  IFlyBehavior fb;
  IQuackBehavior qb;
  IDisplayBehavior db;
  
  Duck(IFlyBehavior fb, IQuackBehavior qb, IDisplayBehavior db){
  ....
  }
  
  Fly()     { fb.Fly();}
  Quack()   { qb.Quack();}
  Display() { db.Display();}
}
```

Now with this you can create any sort of duck injecting appropriate beahvior(Strategy/Algorithms).

```
Duck cityDuck = new Duck(new JetFly(), new SimpleQuack(), new TextDisplay());
Duck rubberDuck = new Duck(new HopFly(), new LoudQuack(), new TextDisplay());
```

### Now, at this point you can add beahviors(Strategy/Algorithms) or change the implementation of the existing beahviour(Strategy/Algorithms) without having callee to change anything.

```
Class Client {
     IStrategy st;
     
     Client(IStrategy st){
          this.st = st;
     }
     
     Run(){
          st.execute();
     }    
}
     
IStrategy {
     execute();
}

ConcreteStrategy Implements IStrategy {
     execute(){
          ...
          ...
     }
}
```

