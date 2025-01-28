package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
    

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


        //Test 12: Random Polynomial Constructor Project 3

        System.out.println("\n----- Testing Random Polynomial Constructor Project 3 -----");

        //Generate and print 5 random polynomials

        for (int i =0; i < 5; i++){
            Polynomial projectThreePolynomial = new Polynomial(true);
            System.out.println("Random Polynomial " + (i+1) + ": " + projectThreePolynomial);
        }

        System.out.println("\n----- End of Testing Random Polynomial Constructor Project 3 -----");

        
        
        System.out.println("\n\n----- Testing Polynomial user input and sort algorithms -----");

        Scanner scanner = new Scanner(System.in);

        //Ask the user how many random polynomials to generate

        System.out.print("\nHow many random polynomiasl would you like to generate?");
        int numPolynomials = scanner.nextInt();

        //Generate an array of random polynomials
        Polynomial[] polynomials2 = new Polynomial[numPolynomials];
        for (int i = 0; i < numPolynomials; i++){
            polynomials2[i] = new Polynomial(true);
        }

        //Display the generated polynomials
        System.out.println("\nGenerated Polynomials:");
        for (Polynomial p : polynomials2){
            System.out.println(p);
        }

        //Sorting on a small number of polynomials

        System.out.println("\nSorting on a small number of polynomials:");
        Polynomial[] smallPolynomials = generateRandomPolynomials(10);
        System.out.println("\nUnsorted Polynomials:");  
        for (Polynomial p : smallPolynomials){
            System.out.println(p);
        }

        //Perform bubble sort (o(n^2)) on the small array
        bubbleSort(smallPolynomials);
        System.out.println("\nSorted Polynomials (Bubble Sort):");
        for (Polynomial p : smallPolynomials){
            System.out.println(p);
        }

        //Shuffle the small array
        shuffleArray(smallPolynomials);

        //Perform Arrasy Sort (O(n log n)) on the small array
        Arrays.sort(smallPolynomials);
        System.out.println("\nSorted Polynomials (O(n log n)):");
        for (Polynomial p : smallPolynomials){
            System.out.println(p);
        }   

        // Measure sort time for 1,000, 5,000, and 10,000 polynomials

        int[] sizes = {1000, 5000, 10000};
        System.out.println("\nMeasuring sort time for 1,000, 5,000, and 10,000 polynomials:");

        for (int size : sizes){
            
            Polynomial[] testArray = generateRandomPolynomials(size);

            //Bubble sort
            Polynomial[] bubbleTest = Arrays.copyOf(testArray, size);
            shuffleArray(bubbleTest);
            long bubbleStartTime = System.nanoTime();
            bubbleSort(bubbleTest);
            long bubbleEndTime = System.nanoTime();
            System.out.println("Bubble Sort (" + size + " objects): " + (bubbleEndTime - bubbleStartTime) + " ns");

            //Arrays.sort() (o(n log n))
            Polynomial[] mergeTest = Arrays.copyOf(testArray, size);
            shuffleArray(mergeTest);
            long mergeStartTime = System.nanoTime();
            Arrays.sort(mergeTest);
            long mergeEndTime = System.nanoTime();
            System.out.println("o(n log n) (" + size + " objects): " + (mergeEndTime - mergeStartTime) + " ns");

        }


        //Test sequential and binary search algorithms

        System.out.println("\nTesting sequential and binary search algorithms:");

        for (int size : sizes) {
            // Generate array of random polynomials
            Polynomial[] testArray = new Polynomial[size];
            for (int i = 0; i < size; i++) {
                testArray[i] = new Polynomial(true); // Random polynomial
            }

            // Sort array for binary search testing
            Arrays.sort(testArray);

            // Generate search terms
            Polynomial foundPolynomial = testArray[new Random().nextInt(size)]; // Guaranteed to exist
            Polynomial notFoundPolynomial = new Polynomial(true); // Likely to not exist

            System.out.println("\nTesting with array size: " + size);

            // Sequential search (existing)
            long startSequentialFound = System.nanoTime();
            int sequentialIndexFound = sequentialSearch(testArray, foundPolynomial);
            long endSequentialFound = System.nanoTime();
            System.out.println("Sequential Search (found): " + (endSequentialFound - startSequentialFound) + " ns");

            // Sequential search (not found)
            long startSequentialNotFound = System.nanoTime();
            int sequentialIndexNotFound = sequentialSearch(testArray, notFoundPolynomial);
            long endSequentialNotFound = System.nanoTime();
            System.out.println("Sequential Search (not found): " + (endSequentialNotFound - startSequentialNotFound) + " ns");

            // Binary search (existing)
            long startBinaryFound = System.nanoTime();
            int binaryIndexFound = binarySearch(testArray, foundPolynomial);
            long endBinaryFound = System.nanoTime();
            System.out.println("Binary Search (found): " + (endBinaryFound - startBinaryFound) + " ns");

            // Binary search (not found)
            long startBinaryNotFound = System.nanoTime();
            int binaryIndexNotFound = binarySearch(testArray, notFoundPolynomial);
            long endBinaryNotFound = System.nanoTime();
            System.out.println("Binary Search (not found): " + (endBinaryNotFound - startBinaryNotFound) + " ns");
        }


        System.out.println("\nTesting Java's Arrays.sort and Arrays.binarySearch with Polynomial class:");
        for (int size : sizes) {
            System.out.println("\nTesting with array size: " + size);

            // Generate an array of random Polynomial objects
            Polynomial[] polyArray = generateRandomPolynomials2(size);

            // Select random targets for searching
            Random random = new Random();
            Polynomial targetFound = polyArray[random.nextInt(polyArray.length)]; // Target that exists
            Polynomial targetNotFound = new Polynomial(new int[]{999, 0, 0}); // Target that doesn't exist

            // Measure sorting time using Arrays.sort
            long startSort = System.nanoTime();
            Arrays.sort(polyArray);
            long endSort = System.nanoTime();
            System.out.println("Arrays.sort time: " + (endSort - startSort) + " ns");

            // Perform binary search for an item that exists
            long startBinarySearch1 = System.nanoTime();
            int indexFound = Arrays.binarySearch(polyArray, targetFound);
            long endBinarySearch1 = System.nanoTime();
            if (indexFound >= 0) {
                System.out.println("Arrays.binarySearch (found): Found " + targetFound +
                        " at index " + indexFound + " in " + (endBinarySearch1 - startBinarySearch1) + " ns");
            } else {
                System.out.println("Arrays.binarySearch (found): Target not found in "
                        + (endBinarySearch1 - startBinarySearch1) + " ns");
            }

            // Perform binary search for an item that doesn't exist
            long startBinarySearch2 = System.nanoTime();
            int indexNotFound = Arrays.binarySearch(polyArray, targetNotFound);
            long endBinarySearch2 = System.nanoTime();
            if (indexNotFound >= 0) {
                System.out.println("Arrays.binarySearch (not found): Unexpectedly found " +
                        targetNotFound + " at index " + indexNotFound + " in " +
                        (endBinarySearch2 - startBinarySearch2) + " ns");
            } else {
                System.out.println("Arrays.binarySearch (not found): Target not found in " +
                        (endBinarySearch2 - startBinarySearch2) + " ns");
            }
        }

        System.out.println("\n\n----- End of Testing Polynomial user input and sort algorithms -----");




        
    }


    
    
    
    // Generate an array of random polynomials
    public static Polynomial[] generateRandomPolynomials(int size) {
        Polynomial[] polynomials = new Polynomial[size];
        for (int i = 0; i < size; i++) {
            polynomials[i] = new Polynomial(true); // Using the constructor that generates random polynomials
        }
        return polynomials;
    }



    // Bubble sort (O(n^2))
    public static void bubbleSort(Polynomial[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // Swap array[j] and array[j + 1]
                    Polynomial temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Shuffle an array (Fisher-Yates algorithm)
    public static void shuffleArray(Polynomial[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Polynomial temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }


    // Sequential search algorithm
    public static int sequentialSearch(Polynomial[] array, Polynomial target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(target) == 0) {
                return i; // Found
            }
        }
        return -1; // Not found
    }


    // Binary search algorithm
    public static int binarySearch(Polynomial[] array, Polynomial target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = array[mid].compareTo(target);

            if (comparison == 0) {
                return mid; // Found
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // Not found






    }
    
    
    // Generate an array of random Polynomial objects
    public static Polynomial[] generateRandomPolynomials2(int numPolynomials) {
        Polynomial[] polynomials = new Polynomial[numPolynomials];
        Random random = new Random();

        for (int i = 0; i < numPolynomials; i++) {
            int degree = random.nextInt(10) + 1; // Random degree between 1 and 10
            int[] coefficients = new int[degree + 1];
            for (int j = 0; j <= degree; j++) {
                coefficients[j] = random.nextInt(20) - 10; // Random coefficients between -10 and 10
            }
            polynomials[i] = new Polynomial(coefficients);
        }

        return polynomials;
    }





}