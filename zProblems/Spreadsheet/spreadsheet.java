// "static void main" must be defined in a public class.
import java.util.Date;

    
    public interface Cell<T> {
        T getValue();
        void setValue(T val);
        
        /*Additonal requirement for DATE*/
        String getFormatedOutput(String format);
        Set<String> getFormats();
        
        // How would you fo 
        // T Sum(Cell c);
        // T RangeSum(int r, );
        // T minus(Cell c);
        // T RangeMinus(int r, );  etc .. 
    }
 
    
    // you can have this impl for  Integer, Double, String etc
    // Can you inject method implementation for getFormatedOutput and getFormats?
    // May be startegy pattern can be used here. we can have FormatStrategy interfact 
            // we can have different format Classes and that object we can pass in a constructor.
    // How would you add Sum() function for cell ? 
    class CellImpl<T> implements Cell<T>{
        T value; 
        
        // 
        public CellImpl(T val){
            value = val;
        }
        
        public T getValue(){
            return value;
        }
        
        public void setValue(T val){
            value = val;
        }
        
        /*Additonal requirement for DATE*/
        public String getFormatedOutput(String format){
            return value.toString();
        }
        
        public Set<String> getFormats(){
            return new HashSet<String>();
        }
        
        T Sum(Cell cell2){
            return this.val + cell2.val;
        }
    }
    
    
    class Spreadsheet {
        // Hash map because 2D array or list we will have to create all cells 
        // incase if we had to do 2d array what object will you create?
        // probably all string Cells object initially 
        // and then service layer would identify the data written and will set appropriate type int cells[row][col]
        Map<String,Cell> map; 
        public Spreadsheet(){
            map = new HashMap<String,Cell>();
        }
        
        private String getHash(int row, int col){
            return "R:"+row+"C:"+col;
        }
        
        Cell getCell(int row, int col) throws InvalidCellNumber{
            validate(row,col);
            String code = getHash(row,col);
            return map.getOrDefault(code, null);
        }
        
        void setCell(int row, int col, Cell cell) throws InvalidCellNumber{
            validate(row,col);
            map.put(getHash(row,col), cell);
        }
        
        void validate(int row,int col) throws InvalidCellNumber{
            if(row<1 || col<1)
                throw new InvalidCellNumber("Invalid Row or Column Number");
        }
    }
    
    class InvalidCellNumber extends Exception {
        public InvalidCellNumber(String s){
            super(s);
        }
    }
    
    // Now, interviewer is saying we want Date Cell and we should be able to provide formated output? 
    class CellDateImpl extends CellImpl<Date>{
        Set<String> formats = new HashSet<String>();
       
        public CellDateImpl(Date val){
            super(val);
            init();
        }
        
        private void init(){
            formats.add("DD::MM:YYYY");
            formats.add("MM::DD:YYYY");
        }
        
        public Date getValue(){
            return super.getValue();
        }
        
        public void setValue(Date val){
            super.setValue(val);
        }
        
        //@override
        public Set getFormats(){ 
            return formats; 
        }
        
        //@override
        public String getFormatedOutput(String format){
            return "";
            // process format 
        }
    }

    
    
    
    /* Note : 1
      // T is compiled as an Object classs 
      // Question is then why use T ? 
     let say you want specific Type of object hi chahiye tujhe .... 
     for eg ... SecurtiyObject and uske Child classes hi chahiye tujhe in Cell 
     that will become Cell<T implements SecurtiyObject> OR Cell<T extends SecurtiyObject>
     ye case main apan kya kiya kikoi bhi object nahi bas specific object hi jayenge kar diya ... 
     and obviously you CANT have Cell<Object implements SecurtiyObject> 
    */
    
    /* Note : 2
       Set<String>  getFormats shouldnt be returning a thing from object level set<>
       ye set object static hona mangta .. it should be for all objects ..
    */
    
