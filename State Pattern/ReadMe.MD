## State Pattern 

#### The State Pattern allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

Imagine you are implementing GumBall machine. It has 4 states. 
  - NoQuarter , HasQuarter , Sold  and Soldout 

Actions on GumBallMachines are 
  - insertQuarter, ejectQuarter, turnCrank, dispense

#### GumBall machine behaves differently depending on the current state and you might end up doing :
```
public class GumballMachine {
  final static int SOLD_OUT = 0; 
  final static int NO_QUARTER = 1; 
  final static int HAS_QUARTER = 2; 
  final static int SOLD = 3;
  int state = SOLD_OUT;

  public void insertQuarter() { 
    if (state == HAS_QUARTER) {
      throw new Exception(“You can’t insert another quarter”); 
    } else if (state == SOLD_OUT) {
      throw new Exception(“You can’t insert a quarter, the machine is sold out”); 
    } else if (state == SOLD) {
      throw new Exception(“Please wait, we’re already giving you a gumball”); 
    } else if (state == NO_QUARTER) {
        state = HAS_QUARTER;
        System.out.println(“You inserted a quarter”);
    }
  }
  public void ejectQuarter(){
    //.... same if else blocks   if HAS_QUARTER then eject and state = NO_QUARTER
  }
  public void turnCrank(){
    //.... same if else blocks   if HAS_QUARTER then state=SOLD
  }
  public void dispense(){
    //.... same if else blocks   
  }
}
```
At this point if you get new requirement - One in Ten get a FREE GUMBALL. We have now winner state that means we have to change code of every meothod. 
Test all of it. 

* First, we’re going to define a State interface that contains a method for every action in the Gumball Machine.
* Then we’re going to implement a State class for every state of the machine. These classes will be responsible for the behavior of the machine when it is in the corresponding state.
* Finally, we’re going to get rid of all of our conditional code and instead delegate to the state class to do the work for us.

![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/State%20Pattern/IMG/State%20Pattern1.png)
![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/State%20Pattern/IMG/State%20Pattern2.png)
![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/State%20Pattern/IMG/State%20Pattern3.png)
![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/State%20Pattern/IMG/State%20Pattern4.png)
