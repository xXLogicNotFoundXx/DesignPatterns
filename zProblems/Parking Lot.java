
class ParkingLotSystem {
    
    ParkingLotSystem()
    List<ParkingFloors> floors;
    List<Entrance> entrances;
    List<Exit> exits;

    String address; 

    void assignAttendant(int gateId, ParkingAttendant attendant);
    ParkingSpot getAvailableParkingSpot(Vehicle v); // iterate through all floors and get the spot 
}

class abstract Gate { // Class becauze we have default attributes in it
    int gateId;
    ParkingAttendant attendant;
}

class Entrance extends Gate {
    Entrance(int id){
    }
    
    ParkingTicket getParking(Vehicle v){
      // get the free spot for vehile 
      // return parking ticket 
    }
}

class Exit extends Gate {
    PaymentInfo processPayemnt(ParkingTicket ticket, Payment p){
      // invaidate ticket mark as paid 
      // free the spot 
    }
}

interface Payment {     // with interface we can add payments as necessary and wont modify that class 
    int chargePayment();
}

class CashPayment {
    int cash; 
    CashPayment(int cash);
    int chargePayment(){
      //... throw exception if cash is not enought   
    }
}

class CreditCardPayment{
    // similar as cash .. throw an exception if card doesnt work 
}

interface ParkingFloor {
    String getDisplay();
    ParkingSpot getAvailableParkingSpot(Vehicle v);
}

class ParkingFloorImpl Implements ParkingFloor {
    List<ParkingSpots> spots; 
    DisplayBoard displayBoard;
    
    ParkingFloorImpl(List<ParkingSpots> spots, DisplayBoard displayBoard){ 
      // for each sport update display board
    }
    
    String getDisplay() { displayBoard.getDisplay(); }
    ParkingSpot getAvailableParkingSpot(Vehicle v ){
      // iterate through list and return available parking or null
    }
}

interface DisplayBoard {
    String getDisplay();
    void incrementCount(ParkingType type);
    void decrementCount(ParkingType type);
}

class DisplayBoardTable implements DisplayBoard {
    Map<ParkingType, Integer> map = new HashMap<>();
    
    String getDisplay(){}
    void incrementCount(ParkingType type){}
    void decrementCount(ParkingType type){}
}

class ParkingSpot {
    int id;
    ParkingType type; // Truck, Motor, 
    boolean isAvailable; 
    Vehicle vehicle; 
}

class ParkingTicket{
    int id;
    int spotId; 
    
}

