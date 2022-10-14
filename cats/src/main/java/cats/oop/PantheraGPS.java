package cats.oop;
import java.util.*;

public class PantheraGPS {
    //constants
    private final Integer maxLongitude = 1000;
    private final Integer maxLatitude = 1000;
    protected final float minSpeed = 0f;
    protected final float maxSpeed = 50.0f;

    //attributes
    private String name;
    private String species;
    private float longitude;
    private float latitude;
    
    private Random longitudeRandom;
    private Random latitudeRandom;

    public PantheraGPS(String name) {
        this.name = name;
        this.species = "pantheraGPS";

        this.longitudeRandom = new Random();
        this.longitudeRandom.setSeed(this.seed(name + "longitude"));
        this.latitudeRandom = new Random();
        this.latitudeRandom.setSeed(this.seed(name + "latitude"));

        this.longitude = longitudeRandom.nextFloat() * maxLongitude;
        this.latitude = latitudeRandom.nextFloat() * maxLatitude;
    }

    public String toString() {
        String s;
        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + name;
        s += ", ";
        s += "species: " + this.species();
        s += ", ";
        s += "longitude: " + this.longitude();
        s += ", ";
        s += "latitude: " + this.latitude();
        s += " }";
        return s;
    }

    public float longitude() {
        return longitude;
    }

    public float latitude() {
        return latitude;
    }

    public String name() {
        return name;
    }

    public String species() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    private Integer seed(String s) {
        Integer seed = 0;
        for (Integer i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);
            seed += (int) ch;
        }
        return seed;
    }

    public void move() {
        this.longitude += longitudeRandom.nextFloat() * maxSpeed;
        this.latitude += latitudeRandom.nextFloat() * maxSpeed;
    }
}
