* https://www.youtube.com/watch?v=v9ejT8FO-7I
* Its about composition rather than inheritance. 
* The strategy pattern is a family of ALGORITHMS, incapusalets each algorithm and makes them interchangable. 
* Strategy lets the algorithm vary independently from clients that use it.
* Enables selecting an algorithm at runtime.
* The decision about which algorithm to use until runtime allows the calling code to be more flexible and reusable.

In this, will learn:
* Inheritance has its problems, and there are other ways of achieving reuse.
* Design Principle : Favor composition over inheritance. (Though not always, Composition it has its advantages & disadvantages) 
* In inheritance sharing algo/implementation downwards is easy. 
* However, sharing code horizontally is difficult between the classes. 

     
lets say:  We have a Duck class and other subclasses of Duck.\
Class Duck
* Quack()
* Fly()
* Display()

Now we have WildDuck, CityDucks, MountainDuck and RubberDuck classes.\
WildDuck, CityDucks shares the same Fly() beahvior. MountainDuck, RubberDuck shares the same Fly() beahvior.\
WildDuck, MountainDuck shares the same Display() beahvior. CityDuck, RubberDuck shares the same Display() beahvior.\

Now at this point you can see lot of code will be duplicated. You can build different heirarchy but you will end up in a situation where the beahviour needed to be 
shared horizontally between the classes. So you can either have duplicate code or you have to find another solution. 


The solution for this is definitel not more inheritance. The solution is **composition**.\
We can have Duck class and 3 interface references in it.
* IFlyBehaviorStrategy, IQuackBehaviorStrategy, IDisplayBehaviorStrategy 

Each of these interafaces can have concrete classes which implements these beahviors like: 
* For IFlyBehaviorStrategy concrete classes JetFlyStrategy, HopFlyStrategy which implements the fly beahvior.
* For IQuackBehaviorStrategy concrete classes SimpleQuackStrategy, LoudQuackStrategy, SqueakQuackStrategy which implements the Quack beahvior.
* For IDisplayBehaviorStrategy concrete classes TextDisplayStrategy, GUIDisplayStrategy which implements the Display beahvior.



```
Class Duck{
  IFlyBehaviorStrategy fb;
  IQuackBehaviorStrategy qb;
  IDisplayBehaviorStrategy db;
  
  Duck(IFlyBehaviorStrategy fb, IQuackBehaviorStrategy qb, IDisplayBehaviorStrategy db){
  ....
  }
  
  Fly()     { fb.Fly();}
  Quack()   { qb.Quack();}
  Display() { db.Display();}
}
```

Now with this you can create any sort of duck injecting appropriate beahvior(Strategy/Algorithms).

```
Duck cityDuck = new Duck(new JetFlyStrategy(), new SimpleQuackStrategy(), new TextDisplayStrategy());
Duck rubberDuck = new Duck(new HopFlyStrategy(), new SqueakQuackStrategy(), new TextDisplayStrategy());

OR 

Class CityDuck extends Duck {
     
     CityDuck(){
          fb = new JetFlyStrategy();
          qb = new SimpleQuackStrategy();
          db = new TextDisplayStrategy();
     }
}

Class RubberDuck extends Duck {
     
     RubberDuck(){
          fb = new HopFlyStrategy();
          qb = new SqueakQuackStrategy();
          db = new TextDisplayStrategy();
     }
}

```

#### Now, at this point you can add beahviors(Strategy/Algorithms) or change the implementation of the existing beahviour(Strategy/Algorithms) without having callee to change anything.


![UML Strategy](http://www.programmingwithwolfgang.com/wp-content/uploads/2018/01/Strategy.jpg)


Use Case 1 : 
* **If you have "List" implementation then rather than implementing sorting algorithm in the List.**
* **We can inject sorting strategy(algo) into the list. And sorting strategy can be independent from the list.**

