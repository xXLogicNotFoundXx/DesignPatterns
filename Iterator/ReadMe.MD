### Well-Managed Collections
* There are lots of ways to stuff objects into a collection.
* Put them in an Array, a Stack, a List, a Map, take your pick. Each has its own advantages and tradeoffs.
* But when your client wants to iterate over your objects, are you going to show him your implementation? 
* We certainly hope not! That just wouldn’t be professional.

## Iterator pattern
![](https://github.com/xXLogicNotFoundXx/DesignPatterns/blob/main/Iterator/IteratorPattern.png)

```
public interface Iterator {
   public boolean hasNext();
   public Object next();
}

public class NameRepository {
   public String names[] = {"Robert" , "John" ,"Julie" , "Laura"};

   // You can have separate interface Container 
   // which has "getIterator(): Object", but i dont see the point doing it.  
   public Iterator getIterator() {
      return new NameIterator();
   }

   private class NameIterator implements Iterator {

      int index=0;

      @Override
      public boolean hasNext() {
      
         if(index < names.length){	// inner classes has access to private members of outer class.
            return true;
         }
         return false;
      }

      @Override
      public Object next() {
      
         if(this.hasNext()){
            return names[index++];
         }
         return null;
      }		
   }
}



public class IteratorPatternDemo {
	
   public static void main(String[] args) {
      NameRepository namesRepository = new NameRepository();

      for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
         String name = (String)iter.next();
         System.out.println("Name : " + name);
      } 	
   }
}


Name : Robert
Name : John
Name : Julie
Name : Laura
```

More on inner classes : https://www.programiz.com/java-programming/nested-inner-class
