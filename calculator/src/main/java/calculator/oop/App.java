package calculator.oop;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        double a = 0.000;
        double b = 0.000;
        Scanner scanner = new Scanner(System.in);
        char command = ' ';

        while (command != 'q') {
            printMenu(a, b);
            command = getCommand(scanner);

            switch(command) {
                case 'a':
                    try {
                        System.out.print("Enter a number: ");
                        a = scanner.nextDouble();
                    } catch(InputMismatchException e) {
                        System.out.println("ERROR: the value entered is not a floating point number");
                    }
                    break;
                case 'b':
                    try {
                        System.out.print("Enter a number: ");
                        b = scanner.nextDouble();
                    } catch(InputMismatchException e) {
                        System.out.println("ERROR: the value entered is not a floating point number");
                    }
                    break;
                case '+':
                    a += b;
                    break;
                case '-':
                    a -= b;
                    break;
                case '*':
                    a *= b;
                    break;
                case '/':
                    if (b == 0) 
                        System.out.println("ERROR: UNABLE TO DIVIDE BY 0");
                    else 
                        a /= b;
                    break;
                case 'c':
                    a = 0;
                    b = 0;
                    break;
                case 'q':
                    System.out.println("Thank you for using Chavvi Calc");
                    break;
                case '1':
                    System.out.println("hi");
                default:
                    System.out.println("ERROR: UNKNOWN COMMAND. TRY AGAIN.");
            }
        }
    }

    private static char getCommand(Scanner scanner) {
        char command = ' ';
        System.out.print("Enter a command: ");
        String rawInput = scanner.nextLine();

        if (rawInput.length() > 0) {
            rawInput.toLowerCase();
            command = rawInput.charAt(0);
        }
        return command;
    }

    private static char getInput(Scanner scanner) {
        char input = ' ';
        System.out.print("Enter a number: ");
        String rawinput = scanner.nextLine();

        if 
    }

    private static void printDashes() {
        for (int i = 0; i < 60; i++)
            System.out.print("-");
        System.out.println();
    }

    private static void printMenu(double a, double b) {
        printDashes();
        System.out.println("Chavvi Calc");
        printDashes();
        System.out.printf("A = %.3f", a);
        System.out.print("           ");
        System.out.printf("B = %.3f", b);
        System.out.println();
        printDashes();
        System.out.println("a       Enter a value for A");
        System.out.println("b       Enter a value for B");
        System.out.println("+       Add");
        System.out.println("-       Subtract");
        System.out.println("/       Divide");
        System.out.println("*       Multiply");
        System.out.println("c       Clear");
        System.out.println("q       Quit");
        printDashes();
    }
}
