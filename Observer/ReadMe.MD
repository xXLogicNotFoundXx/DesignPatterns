## Observer Pattern 

### The Observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically.

* In my opinion it is almost like Pub-Sub model (Push Model).
* In observer pattern we dont talk about publisher but there has to be someone who feeds data OR cahnge the sate of the Subject Class. 

### In the end you have a class Leader. Other Observer classes can subscribe/unsubscribe to Leader class. Leader class in some way gets new data (OR changes state). Once its state it changed (OR new data available) Leader class notifies all subscribed observers. 

![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Observer/IMG/Observer%20Pattern.png)
