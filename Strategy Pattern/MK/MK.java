/******************* Client ************************/

public class Fighter {
    private String mName;
    private KickStrategy mKickStrategy;
    private RollStrategy mRollStrategy;

    public Fighter(String name, KickStrategy kickStrategy) {
        mName = name;
        mKickStrategy = kickStrategy;
        mRollStrategy = rollStrategy;
    }

    public void kick() {
        System.out.print(mName + ":");
        mKickStrategy.kick();
    }
    
    public void changeKickStrategy(KickStrategy kickStrategy) {  // IMP we can also change the strategy in the lifecycle of the object if we want to
        mKickStrategy = kickStrategy;
    }
}

// NOTE : You can have abstract Fighter and concrete subclasses like Scorpion, SubZero etc with predefined strategy initiated in the constructor. 


/************* Strategies ***************/
public interface KickStrategy {
    void kick();
}

public class FlyingKickStrategy implements KickStrategy {
    @Override
    public void kick() {
        System.out.println("Fly kicking");
    }
}

public class SimpleKickStrategy implements KickStrategy {       
    @Override
    public void kick() {
        System.out.println("Kicking");
    }
}


/************************** MAIN **********************************/
public class Main {
 public static void main(String[] args) {
        Fighter f1 = new Fighter("SubZero", new FlyingKickStrategy(), new BackRollStrategy());
        f1.kick();

        Fighter f2 = new Fighter("Pandu", new SimpleKickStrategy(), new NoRollStrategy());
        f2.kick();

        // Pandu gets FlyingKickPower
        f2.changeKickStrategy(new FlyingKickStrategy());
        f2.kick();
 }
} 
