package cats.oop;
import java.util.*;

public class Panthera extends PantheraGPS {
    
    private int weight;
    private boolean sleepsInTrees;
    
    private Random randWeight = new Random();
    private Random randSpeed = new Random();

    // constructor
    public Panthera(String name) {
        // call the super-class (parent) to instatiate it
        super(name);
        // initialize attributes
        this.setSpecies("panthera");
        weight = randWeight.nextInt((590) + 1) + 10;    
    }

    protected void setSleepsInTrees(boolean sleepsInTrees) {
        this.sleepsInTrees = sleepsInTrees; 
    }

    // serializes attributes into a string
    @Override // override superclass method
    public String toString() {
        String s;
        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + this.name();
        s += ", ";
        s += "species: " + this.species();
        s += ", ";
        s += "longitude: " + this.longitude();
        s += ", ";
        s += "latitude: " + this.latitude();
        s += " }";
        return s;
    }

    public void roar() {
        System.out.print("Rrrrrrrrroooooooaaaaarrrrr!");
    }

    public float speed() {
        int speed = randSpeed.nextInt((50) + 1);
        return speed;
    }


}
