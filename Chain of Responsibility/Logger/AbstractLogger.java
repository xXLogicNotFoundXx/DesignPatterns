public abstract class AbstractLogger {
   public static int INFO = 1;
   public static int DEBUG = 2;
   public static int ERROR = 3;

   protected int level;

   //next element in chain or responsibility
   protected AbstractLogger nextLogger;

   public void setNextLogger(AbstractLogger nextLogger){
      this.nextLogger = nextLogger;
   }

   public void logMessage(int level, String message){
      if(this.level <= level){
         write(message);
      }
      if(nextLogger !=null){
         nextLogger.logMessage(level, message);
      }
   }
   
   // See how this method is protected and called in public method logMessage()
   // Subclasses are supposed to implement this method/ handle this
   abstract protected void write(String message);   
	
  
   /*     NOTE
   In a way this specific one the way we implemented. 
   It is almost like template method pattern but has a chain in it. 
   logMessage() is our template method. 
   write() is our primitive method which subclasses are supposed to handle.
   */
	
}
