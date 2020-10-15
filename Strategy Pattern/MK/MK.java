/*******************************************/

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
    
    public void changeKickStrategy(KickStrategy kickStrategy) {
        mKickStrategy = kickStrategy;
    }
}

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
