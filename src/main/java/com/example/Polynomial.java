package com.example;

import java.util.ArrayList;
import java.util.Random;

public class Polynomial {

    private ArrayList<Double> coefficients;
    private int degree;
    private Random random = new Random();

    //empty constructor
    public Polynomial(){
        this.coefficients = new ArrayList<>();
        this.coefficients.add(0.0);
        this.degree = 0;
    }

    //Constructor that takes a array of coefficients
    public Polynomial(int[] coefficients){
        this.coefficients = new ArrayList<>();
        for(double coeff : coefficients){
            this.coefficients.add(coeff);
        }
        
        trimLeadingZeros(); // remove leading zeros
        this.degree = this.coefficients.size() - 1;
        
    }

    //Constructor that takes a ArrayList of coefficients
    public Polynomial(ArrayList<Double> coefficients){
        this.coefficients = new ArrayList<>(coefficients);
        trimLeadingZeros(); // remove leading zeros
        this.degree = this.coefficients.size() - 1;
    }

    //Constructor that generates a random polynomial of a given degree
    public Polynomial(int degree){
        if (degree < 0){
            throw new IllegalArgumentException("Degree must be a non-negative integer");
        }

        this.coefficients = new ArrayList<>();

        for (int i = 0; i <= degree; i++){
            // generate a double value name coeff that makes a number between -15 and 15
            double coeff = random.nextDouble() * 30 - 15;
            this.coefficients.add(coeff);
        }

        //Leading coefficient should not be non-zero
        if (this.coefficients.get(degree) == 0){
            this.coefficients.set(degree, random.nextDouble() * 14 + 1);
        }

        this.degree = degree;


    }

    //Getter: return the degree of the polynomial
    public int getDegree(){
        return this.degree;
    }

    //Gettter: Return an array of all coefficients up to the degree
    public double[] getCoefficients(){
        double[] coeffArray = new double[this.degree + 1];
        for (int i = 0; i <= this.degree; i++){
            coeffArray[i] = this.coefficients.get(i);
        }

        return coeffArray;

    }

    //Getter: Return the coefficient for a specified power
    public double getCoefficient(int power){
        if (power < 0 || power > this.degree){
            throw new IllegalArgumentException("Power out of bounds for this polynomial.");
        }

        return this.coefficients.get(power);
    }

    



















}
