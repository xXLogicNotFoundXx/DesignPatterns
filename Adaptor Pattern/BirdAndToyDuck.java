// Adaptee
interface Bird { 
    public void fly(); 
    public void makeSound(); 
} 
  
class Sparrow implements Bird 
{ 
    // a concrete implementation of bird 
    public void fly() 
    { 
        System.out.println("Flying"); 
    } 
    public void makeSound() 
    { 
        System.out.println("Chirp Chirp"); 
    } 
} 
/*******************/
// Client
interface ToyDuck { 
    public void squeak(); 
} 
  
class PlasticToyDuck implements ToyDuck { 
    public void squeak() { 
        System.out.println("Squeak"); 
    } 
} 
/*******************/

class BirdAdapter implements ToyDuck { 
    // You need to implement the interface your client expects to use. 
    Bird bird; 
    public BirdAdapter(Bird bird) { 
        // we need reference to the object we are adapting 
        this.bird = bird; 
    } 
  
    public void squeak() { 
        // translate the methods appropriately 
        bird.makeSound(); 
    }
} 
  
class Main { 
    public static void main(String args[]) { 
        Sparrow sparrow = new Sparrow(); 
        System.out.println("Sparrow..."); 
        sparrow.fly(); 
        sparrow.makeSound(); 
        
        ToyDuck toyDuck = new PlasticToyDuck(); 
        System.out.println("ToyDuck..."); 
        toyDuck.squeak(); 
  
        // Wrap a bird in a birdAdapter so that it  
        // behaves like toy duck 
        ToyDuck birdAdapter = new BirdAdapter(sparrow); 
  
        // toy duck behaving like a bird  
        System.out.println("BirdAdapter..."); 
        birdAdapter.squeak(); 
    } 
} 
/*
Output:

Sparrow...
Flying
Chirp Chirp

ToyDuck...
Squeak

BirdAdapter...
Chirp Chirp
*/
