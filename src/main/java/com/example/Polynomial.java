package com.example;

import java.util.ArrayList;
import java.util.List;
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
        
        updateDegree(); // remove leading zeros
        this.degree = this.coefficients.size() - 1;
        
    }

    //Constructor that takes a ArrayList of coefficients
    public Polynomial(ArrayList<Double> coefficients){
        this.coefficients = new ArrayList<>(coefficients);
        updateDegree(); // remove leading zeros
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

    //Setter: Set the coefficient for a special power

    public void setCoefficient(int power, double newValue){
        if (power < 0){
            throw new IllegalArgumentException("Power must be a non-negative integer: " + power);
        }

        //Expand the list if needed to acommadate the power

        while (power >= this.coefficients.size()){
            this.coefficients.add(0.0);
        }

        //set the new value
        this.coefficients.set(power, newValue);

        //Update the degree if the leading term changes

        updateDegree();

    }

    //setter: Set all coefficients to a new set of values

    public void setCoefficients(List<Double> newCoefficients){
        this.coefficients = new ArrayList<>(newCoefficients);
        updateDegree();
    }

    // Add two polynomials
    public Polynomial add(Polynomial p){
        int maxDegree = Math.max(this.degree, p.getDegree());
        ArrayList<Double> resultCoefficients = new ArrayList<>();

        for (int i = 0; i <= maxDegree; i++){
            double coeff1 = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0.0;
            double coeff2 = (i < p.coefficients.size()) ? p.coefficients.get(i) : 0.0;
            resultCoefficients.add(coeff1 + coeff2);

        }

        return new Polynomial(resultCoefficients);
    }

    //Subtract two polynomials
    public Polynomial subtract(Polynomial p){
        int maxDegree = Math.max(this.degree, p.getDegree());
        ArrayList<Double> resultCoefficients = new ArrayList<>();

        for (int i = 0; i <= maxDegree; i++){
            double coeff1 = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0.0;
            double coeff2 = (i < p.coefficients.size()) ? p.coefficients.get(i) : 0.0;
            resultCoefficients.add(coeff1 - coeff2);

        }

        return new Polynomial(resultCoefficients);
    }




    //Update the degree of the polynomial
    private void updateDegree(){
        int maxDegree = 0; //Initialize the max degree to 0

        for (int i = this.coefficients.size() - 1; i >= 0; i--){
            if (this.coefficients.get(i) != 0){
                maxDegree = i;
                break;
            }
        }

        degree = maxDegree;

    }

    //Method: Evaluate the polynomial at a given value of x
    public double evaluate(double x){
        double result = 0.0;

        for (int i = 0; i <= this.coefficients.size(); i++){
            result += this.coefficients.get(i) * Math.pow(x, i);
        }

        return result;
    }

    //Method to clear all coefficients (reset to zero polynomial)
    public void clear(){
        this.coefficients = new ArrayList<>();
        this.coefficients.add(0.0);
        this.degree = 0;
    }   

    //toString method
    @Override
    public String toString(){

        if (degree == 0 && coefficients.get(0) == 0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = degree; i >= 0; i--){
            double coeff = coefficients.get(i);
            if (coeff != 0){
                continue;
            }

            if (sb.length() > 0){
                sb.append(coeff > 0 ? " + " : " - ");
            } else if (coeff < 0){
                sb.append("-");
            }

            double absCoeff = Math.abs(coeff);
            if (absCoeff != 1 || i == 0){
                sb.append(absCoeff);
            }

            if (i > 0){
                sb.append("x");
                if (i > 1){
                    sb.append("^").append(i);
                }
            }
        }

        return sb.toString();

    }

    



















}
