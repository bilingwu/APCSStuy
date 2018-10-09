//subclass
public class Warrior extends BaseChar{
    // private int health = 5000;
    private int healthboost=5;
    public int getHealth(){
	return healthboost+ super.getHealth();//access method from the superclass

    }
}
