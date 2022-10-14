

package cats.oop;
import java.util.*;

/*
 * Menu class for the african big cat app
 */
public class Menu {
    // attributes
    private Scanner input;
    // constructor
    public Menu() {
        // initialize attributes
        this.input = new Scanner(System.in);
    }
    // prints the menu
    public void print() {
        printLine();
        System.out.println("African Big Cats App");
        printLine();
        /*
            TIP:
            In this area of the code, the additional commands need to be created 
and added to the menu.
        */
        printCommand('c',"[C]reates a big cat");
        printCommand('d', "[D]eletes a big cat");
        printCommand('f', "[F]inds a big cat");
        printCommand('l',"[L]ists all big Cats");
        printCommand('q',"[Q]uits");
        printLine();
    }
    private static void printLine() {    
    System.out.println("----------------------------------------------------------" );
    }

    private static void printCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    // get first character from input
    public Character getCommand() {
        Character command = '_';
        String rawInput = input.nextLine();
        
        if (rawInput.length() > 0) {
            rawInput = rawInput.toLowerCase();
            command = rawInput.charAt(0);
        }
        return command;
    }

    // command switch
    public Boolean executeCommand(Character command, LinkedList<Panthera> catList) {
        Boolean success = true;
        switch(command) {
            case 'c':
                executeCreate(catList);
                break;
            case 'd': 
                executeDelete(catList);
            case 'f':
                executeFind(catList);
            case 'l':
                executeList(catList);
                break;
            case 'q':
                executeQuit();
                break;
            default:
                System.out.println("ERROR: Unknown commmand");
                success = false;
          }
        return success;
    }

    // update the position of all the cats
    public void update(LinkedList<Panthera> catList) {
        // update by moving all the cats
        for (Panthera cat: catList) {
            cat.move();
        }
    }
    // quit the app
    public void executeQuit() {
        // close the scannner
        input.close();
        System.out.println();
        printLine();
        System.out.println("Thank you for using the African Big Cats App!");
        printLine();
        System.out.println();
    }

    public Panthera getNewCat(String name) {
        try {
        System.out.print("Enter " + name + "'s species: ");
        String species = input.nextLine();
        species = species.toLowerCase();
        Panthera result = new Tiger(name);
        
        switch (species) {
            case "tiger":
                result = new Tiger(name);
                break;
            case "jaguar":
                result = new Jaguar(name);
                break;
            case "lion":
                result = new Lion(name);
                break;
            default:
                System.out.print("Error: Cat type does not exist. Try again.");
                getNewCat(name);
            }
        return result;
        } catch(InputMismatchException e) {
            System.out.print("Error: the name entered is a not a word. Try again.");
            return getNewCat(name);
        }
    }

    public void executeFind(LinkedList<Panthera> catList) {
        System.out.println();
        System.out.print("Enter the name of the cat to be found: ");
        String name = input.nextLine();

        for (int i = 0; i < catList.size(); i++) {
            if (catList.get(i).name().toUpperCase().contains(name.toUpperCase())) {
                System.out.println(catList.get(i).toString());
            }
        }
    }

    public void executeDelete(LinkedList<Panthera> catList) {  
        System.out.println();
        System.out.print("Enter the name of the cat to be deleted: ");
        String name = input.nextLine();
        
        for (int i = 0; i < catList.size(); i++) {
            if (name.toUpperCase() == catList.get(i).name().toUpperCase())
                catList.remove(i);
            else {
                System.out.print("There is no cat named " + name + " to be deleted. Try again");
                executeDelete(catList);
            }
        }
    }

    // create a cat, if it's unique
    public void executeCreate(LinkedList<Panthera> catList) {
        // get the name
        System.out.print("Enter the name of the cat to be created: ");
        String name = input.nextLine();
        
        if (catList.size() == 0) {
            Panthera cat = getNewCat(name);
            catList.add(cat);
        }

        for (int i = 0; i < catList.size(); i++) {
            if (name.toUpperCase() == catList.get(i).name().toUpperCase()) {
                System.out.print("Another cat already has this name. Please enter a different name.");
                executeCreate(catList);
            }
            else { 
                Panthera cat = getNewCat(name);
                catList.add(cat);
            }
        }
    }

    // list all big cats 
    public void executeList(LinkedList<Panthera> catList) {
        System.out.println();
        printLine();
        System.out.println("African Big Cat List");
        printLine();
        Panthera cat;
        if (catList.size() > 0) {
            for (Integer i = 0; i < catList.size(); i++) {
                cat = catList.get(i);
                System.out.println(cat);
            }
        } else {
            System.out.println("There are no African Big Cats. :(");
        }
        System.out.println();
    }

    /*
        TIP:
        Additional methods and functionality need to be added to this class.
    */
}
