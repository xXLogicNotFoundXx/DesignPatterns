## The Decorator Pattern 
* The Decorator Pattern  attaches additional responsibilities to an object dynamically. 
* Decorators provide a flexible alternative to subclassing for extending functionality.

Say if you have **Beverage** abstract class and sub classes as **Decaf, Expresso, DarkRoast** ect.\
How would you add condiments to it like **Soya, Milk, Mocha, Cream** etc?\
In the end you should be to be able to calculate the cost of the beverage.\

One way to add classes of DecafSoya, DecafMilk, DecafDarkRoast .... but that would cause **class explosion**.\
One way of doing this would be adding **hasSoy(), hasMilk(), hasMocha(), hasCream()** in **Beverage** class and the cost of the beverage will be calculated depending on all these return values.
* What if a customer wants a double mocha?
* At this point you can see new condiments will force us to add new methods and alter the cost method in the superclass.
* We may have new beverages. For some of these beverages (iced tea?), the condiments may not be appropriate, yet the **Tea** subclass will still inherit methods like hasSoy().

This violates The Open-Closed Principle.

**The Open-Closed Principle - Classes should be open for extension, but closed for modification.**

Our goal is to allow classes to be easily extended to incorporate new behavior without modifying existing code. What do we get if we accomplish this? Designs that are resilient to change and flexible enough to take on new functionality to meet changing requirements.\

**While inheritance is powerful, it doesn’t always lead to the most flexible or maintainable designs.**


![UML Decorator](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Decorator%20Pattern/img/UML%20Decorator.png)

![UML Beverage](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Decorator%20Pattern/img/UMLBeverage.png)

we’re subclassing the abstract class Beverage in order to have the correct type, not to inherit its behavior.\
The behavior comes in through the composition of decorators.
### In my opinion this wasn't a great example of decorator pattern. You could have had "addCondiments(Condiments c)" in the Beverage class and you could iterate through to calulate the total cost and the description. 

# Real World Decorators JAVA I/O :
![UML JAVA IO](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Decorator%20Pattern/img/UMLJavaIO.png)

Now you can add you own decorator **LowerCaseInputStream** that converts all uppercase characters to lowercase in the input stream.

```
import java.io.*;

public class LowerCaseInputStream extends FilterInputStream {

	public LowerCaseInputStream(InputStream in) {
		super(in);
	}
 
	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : Character.toLowerCase((char)c));
	}
		
	public int read(byte[] b, int offset, int len) throws IOException {
		int result = super.read(b, offset, len);
		for (int i = offset; i < offset+result; i++) {
			b[i] = (byte)Character.toLowerCase((char)b[i]);
		}
		return result;
	}
}
```

## Use Case 1 
You can use decorator pattern if you want to deprecate some APIs or a class. We can wrap/decorator that class.\
You can intercept that API call and either make the original class call OR ignore it OR modify that call as you like.\

## Use Case 2 
Another one, let's say you have a class and now all the method needed to be Audited and plus you need to add some Logs to all those methods.\
However, these audit and log depends on some auditEnable/logEnable flag.\
You can easily acheive that with Decorator Pattern. You can wrap original class with a decorators and depending on the flags you can return :
```
new AuditDecorator(new OriginalClass());   			// Audit enabled
new LogDecorator(new OriginalClass());  			// Logs enabled 
new AuditDecorator(new LogDecorator(new OriginalClass()))	// Audit & Logs enabled 
```

