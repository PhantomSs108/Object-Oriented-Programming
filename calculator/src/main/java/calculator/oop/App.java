package calculator.oop;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        double a = 0.000;
        double b = 0.000;
        printMenu(a, b);

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
    }
}
