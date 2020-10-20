// COMPONENT ABSTRACT - This can be interface too 
public abstract class Beverage {
  String description = “Unknown Beverage”;
  
  public String getDescription() { 
    return description;
  }
  
  public abstract double cost(); 
}

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




// DECORATOR ABSTRACT -- [this doesn't have to be abstract in JAVA IO the decorator base case FilterInputStream is instantiable ] 
public abstract class CondimentDecorator extends Beverage {   
  public abstract String getDescription();
}

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


public class StarbuzzCoffee {
  public static void main(String args[]) { 
    // Simple Espresso
    Beverage beverage = new Espresso(); 
    System.out.println(beverage.getDescription() + “ $” + beverage.cost()); 
    
    // DarkRoast + 2 Mocha + Whip 
    Beverage beverage2 = new DarkRoast();
    beverage2 = new Mocha(beverage2); 
    beverage2 = new Mocha(beverage2); 
    beverage2 = new Whip(beverage2);
    System.out.println(beverage2.getDescription() + “ $” + beverage2.cost());
  }
}
