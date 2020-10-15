// COMPONENT ABSTRACT 
public abstract class Beverage {
  String description = “Unknown Beverage”;
  
  public String getDescription() { 
    return description;
  }
  
  public abstract double cost(); 
}

// DECORATOR ABSTRACT
public abstract class CondimentDecorator extends Beverage {    // IMP Decorator extends the base component so it has the same type 
  public abstract String getDescription();
}

/************************************ COMPONENT - Concrete classes ******************/
public class Espresso extends Beverage {
  public Espresso()    {  description = “Espresso”;}
  public double cost() {  return 1.99;} 
}

public class Decaf extends Beverage { 
    public Decaf() {...}
     public double cost() {...}
}

public class HouseBlend extends Beverage { 
    public HouseBlend() {...}
     public double cost() { ...}
}
/* *********************************** END COMPONENT - Concrete classes ******************/




/************************************ DECORATOR - Concrete classes ******************/
public class Mocha extends CondimentDecorator { 

  Beverage beverage;                                // IMP contians Beverage object [Composition]
  public Mocha(Beverage beverage) {                 // IMP cannot instantiate without concrete Beverage class [Espresso, DarkRoast, Decaf..]
    this.beverage = beverage;
  }
  public String getDescription() { return beverage.getDescription() + “, Mocha”; }  // how the recursion is used to decorate (add functionality)
  public double cost() { return .20 + beverage.cost();}                             // how the recursion is used to decorate (add functionality)
}

public class Milk extends CondimentDecorator { 

  Beverage beverage;                                // IMP contians Beverage object [Composition]
  public Milk(Beverage beverage) {                  // IMP cannot instantiate without concrete Beverage class [Espresso, DarkRoast, Decaf..]
    this.beverage = beverage;
  }
  public String getDescription() { return beverage.getDescription() + “, Milk”; }
  public double cost() { return .20 + beverage.cost();} 
}
/************************************ END  DECORATOR - Concrete classes ******************/

public class StarbuzzCoffee {
  public static void main(String args[]) { 
    // Simple Espresso
    Beverage beverage = new Espresso(); 
    System.out.println(beverage.getDescription() + “ $” + beverage.cost()); 
    
    // Coffee 
    Beverage beverage2 = new DarkRoast();
    beverage2 = new Mocha(beverage2); 
    beverage2 = new Mocha(beverage2); 
    beverage2 = new Whip(beverage2);
    System.out.println(beverage2.getDescription() + “ $” + beverage2.cost());
  }
}
