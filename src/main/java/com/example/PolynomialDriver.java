package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
    

public class PolynomialDriver {
    public static void main(String[] args) {
        System.out.println("----- Testing Polynomial Class -----");

        // Test 1: Empty constructor

        Polynomial p1 = new Polynomial();
        System.out.println("Test 1: Empty Constructor");
        System.out.println("Empty Polynomial p1 = " + p1);
        System.out.println();

        // Test 2: Constructure with Coefficients

        ArrayList<Double> coefficients = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0));
        Polynomial p2 = new Polynomial(coefficients);
        System.out.println("Test 2: Constructor with Coefficients (ArrayList)");
        System.out.println("Polynomial made with an ArrayList p2 = " + p2);
        System.out.println();
        
        // Test 3: Constructor with int array

        int[] coefficients2 = {1, 2, 3, 4};
        Polynomial p3 = new Polynomial(coefficients2);
        System.out.println("Test 3: Constructor with int array");
        System.out.println("Polynomial made with an array p3 = " + p3);
        System.out.println();

        // Test 4: Random polynomial constructor base on degree input

        Polynomial p4 = new Polynomial(4); //Degree 4 with random coefficients
        System.out.println("Test 4: Random polynomial base on degree input");
        System.out.println("Polynomial made with inputting a degree p4 = " + p4);
        System.out.println();

        // Test 5: Getters

        System.out.println("Test 5: Getters");
        System.out.println("The polynomial p2 is: " + p2);
        System.out.println("Degree of p2:" + p2.getDegree());
        System.out.println("Coefficient of p2: " + Arrays.toString(p2.getCoefficients())); 
        System.out.println("Coefficient of x^2 in p2: " + p2.getCoefficient(2));
        System.out.println();

        // Test 6: Setters

        System.out.println("Test 6: Setters");
        System.out.println("The original polynomial p2 is: " + p2);
        p2.setCoefficient(2, 5.0); //Change coefficient of x^2 to 5
        System.out.println("p2 after changing coefficient of x^2 to 5: " + p2);
        ArrayList<Double> newCoefficients = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
        p2.setCoefficients(newCoefficients); //Change all coefficients
        System.out.println("p2 after changing all coefficients: " + p2);
        System.out.println();

        // Test 7: Clear Method

        System.out.println("Test 7: Clear Method");
        System.out.println("p2 before clear: " + p2);
        p2.clear();
        System.out.println("p2 after clear: " + p2);
        System.out.println();


        // Test 8: Evaluate Method

        System.out.println("Test 8: Evaluate Method");
        p2.setCoefficients(newCoefficients);
        System.out.println("p2 = " + p2);
        double valueAtX = 2.0;
        System.out.println("Value of p2 at x = " + valueAtX + " is " + p2.evaluate(valueAtX));
        System.out.println();

        //Test 9: addition and subtraction

        System.out.println("Test 9: Addition and Subtraction");
        Polynomial p5 = new Polynomial(new ArrayList<>(Arrays.asList(7.0, 8.0, 9.0, 10.0, 11.0)));
        System.out.println("Polynomial p5 = " + p5);
        System.out.println("Polynomial p2 = " + p2);
        Polynomial sum = p5.add(p2);
        Polynomial difference = p5.subtract(p2);
        System.out.println("p5 + p2 = " + sum);
        System.out.println("p5 - p2 = " + difference);
        System.out.println();

        //Test 10: CompareTo Method

        System.out.println("Test 10: CompareTo Method");
        System.out.println("Polynomial p5 = " + p5);
        System.out.println("Polynomial p2 = " + p2);
        System.out.println("Comparing p2 and p5: " + p2.compareTo(p5));
        System.out.println("Comparing p5 and p2: " + p5.compareTo(p2));
        Polynomial p6 = new Polynomial(newCoefficients);
        System.out.println("Polynomial p6 = " + p6);
        System.out.println("Comparing p2 and p6: " + p2.compareTo(p6));
        System.out.println();  
        
        

        //Test 11: List of Random Polynomials 

        System.out.println("Test 11: List of Random Sorted Polynomials");

        ArrayList<Polynomial> polynomials = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            Random rand = new Random();
            //Generate degree between 1 and 15
            int degree = rand.nextInt(15) + 1;
            Polynomial p = new Polynomial(degree);
            polynomials.add(p);
        }



        System.out.println("\nList of unsorted polynomials:");
        for (Polynomial p : polynomials){
            System.out.println("\n" + p);
        }

        Collections.sort(polynomials);

        System.out.println("\nList of sorted polynomials:");
        for (Polynomial p : polynomials){
            System.out.println("\n" + p);
        }





        System.out.println("\n----- End of Testing Polynomial Class -----");



































        
    }
}