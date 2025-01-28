package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a polynomial with real-valued coefficients.
 * This class provides methods for polynomial arithmetic, evaluation, and
 * comparison.
 * 
 * @Author: Miguel Alexander Nunez Palomares
 * @Version: 1.0
 * @See java.util.ArrayList, java.util.List, java.util.Random
 */

public class Polynomial implements Comparable<Polynomial> {
    /** List of coefficients for the polynomial. */
    private ArrayList<Double> coefficients;
    /**
     * The degree of the polynomial (highest power of x with a non-zero
     * coefficient).
     */
    private int degree;
    /** Random generator for creating random polynomials. */
    private Random random = new Random();

    /**
     * Default constructor. Initializes the polynomial to zero (0).
     */
    public Polynomial() {
        this.coefficients = new ArrayList<>();
        this.coefficients.add(0.0);
        this.degree = 0;
    }

    /**
     * Constructs a polynomial using an array of integer coefficients.
     * 
     * @param coefficients the array of coefficients for the polynomial
     */
    public Polynomial(int[] coefficients) {
        this.coefficients = new ArrayList<>();
        for (double coeff : coefficients) {
            this.coefficients.add(coeff);
        }

        updateDegree(); // remove leading zeros
        this.degree = this.coefficients.size() - 1;

    }

    /**
     * Constructs a polynomial using a list of coefficients.
     * 
     * @param coefficients the list of coefficients for the polynomial
     */
    public Polynomial(ArrayList<Double> coefficients) {
        this.coefficients = new ArrayList<>(coefficients);
        updateDegree(); // remove leading zeros
        this.degree = this.coefficients.size() - 1;
    }

    /**
     * Constructs a random polynomial of a specified degree.
     * Coefficients are generated randomly between -15.0 and 15.0.
     * 
     * @param degree the degree of the polynomial
     * @throws IllegalArgumentException if the degree is negative
     */
    public Polynomial(int degree) {
        if (degree < 0) {
            throw new IllegalArgumentException("Degree must be a non-negative integer");
        }

        this.coefficients = new ArrayList<>();

        for (int i = 0; i <= degree; i++) {
            // generate a double value name coeff that makes a number between -15 and 15
            double coeff = random.nextDouble() * 30 - 15;
            coeff = Math.round(coeff * 10) / 10.0; // round to one decimal place
            this.coefficients.add(coeff);
        }

        // Leading coefficient should not be non-zero
        if (this.coefficients.get(degree) == 0) {
            double newCoeff = random.nextDouble() * 14 + 1;
            newCoeff = Math.round(newCoeff * 10) / 10.0;
            this.coefficients.set(degree, newCoeff);
        }

        this.degree = degree;

    }

    /**
     * Project 3
     * Constructs a random polynomial for a project with random degrees and
     * coefficients.
     * If the flag is false, initializes to zero (0).
     * 
     * @param randomDegreeeAndCoefficients true to generate a random polynomial,
     *                                     false for zero polynomial
     */
    public Polynomial(boolean randomDegreeeAndCoefficients) {
        if (randomDegreeeAndCoefficients) {
            // Generate a random degree between 3 and 10 (inclusive)
            int randomDegree = random.nextInt(8) + 3;

            this.coefficients = new ArrayList<>();

            // Generate random coefficients in the range [-5.0, 5.0]
            for (int i = 0; i <= randomDegree; i++) {
                double coeff = random.nextDouble() * 10 - 5;
                coeff = Math.round(coeff * 10) / 10.0; // round to one decimal place
                this.coefficients.add(coeff);
            }

            // Ensure the leading coefficient is non-zero
            if (this.coefficients.get(randomDegree) == 0) {
                double newCoeff = random.nextDouble() * 4.9 + .1; // Random values between 0.1 and 5.0
                newCoeff = Math.round(newCoeff * 10) / 10.0;
                this.coefficients.set(randomDegree, newCoeff);
            }

            this.degree = randomDegree;

        } else {
            // If the flag is false, fallback to an empty constructor
            this.coefficients = new ArrayList<>();
            this.coefficients.add(0.0);
            this.degree = 0;
        }

    }

    /**
     * Gets the degree of the polynomial.
     * 
     * @return the degree of the polynomial
     */
    public int getDegree() {
        return this.degree;
    }

    /**
     * Gets the coefficients of the polynomial as an array.
     * 
     * @return an array of coefficients
     */
    public double[] getCoefficients() {
        double[] coeffArray = new double[this.degree + 1];
        for (int i = 0; i <= this.degree; i++) {
            coeffArray[i] = this.coefficients.get(i);
        }

        return coeffArray;

    }

    /**
     * Gets the coefficient for a specified power of x.
     * 
     * @param power the power of x
     * @return the coefficient for the specified power
     * @throws IllegalArgumentException if the power is out of bounds
     */
    public double getCoefficient(int power) {
        if (power < 0 || power > this.degree) {
            throw new IllegalArgumentException("Power out of bounds for this polynomial.");
        }

        return this.coefficients.get(power);
    }

    /**
     * Sets the coefficient for a specified power of x.
     * 
     * @param power    the power of x
     * @param newValue the new coefficient value
     * @throws IllegalArgumentException if the power is negative
     */

    public void setCoefficient(int power, double newValue) {
        if (power < 0) {
            throw new IllegalArgumentException("Power must be a non-negative integer: " + power);
        }

        // Expand the list if needed to acommadate the power

        while (power >= this.coefficients.size()) {
            this.coefficients.add(0.0);
        }

        // set the new value
        this.coefficients.set(power, newValue);

        // Update the degree if the leading term changes

        updateDegree();

    }

    /**
     * Setter method to update the coefficients of the polynomial.
     * 
     * @param newCoefficients a list of new coefficients to replace the current ones
     */

    public void setCoefficients(List<Double> newCoefficients) {
        this.coefficients = new ArrayList<>(newCoefficients);
        updateDegree();
    }

    /**
     * Adds this polynomial to another polynomial.
     * The resulting polynomial will have the sum of the corresponding coefficients.
     * 
     * @param p the polynomial to be added to this polynomial
     * @return a new polynomial representing the sum of the two polynomials
     */
    public Polynomial add(Polynomial p) {
        int maxDegree = Math.max(this.degree, p.getDegree());
        ArrayList<Double> resultCoefficients = new ArrayList<>();

        for (int i = 0; i <= maxDegree; i++) {
            double coeff1 = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0.0;
            double coeff2 = (i < p.coefficients.size()) ? p.coefficients.get(i) : 0.0;
            resultCoefficients.add(coeff1 + coeff2);

        }

        return new Polynomial(resultCoefficients);
    }

    /**
     * Subtracts another polynomial from this polynomial.
     * The resulting polynomial will have the difference of the corresponding
     * coefficients.
     * 
     * @param p the polynomial to be subtracted from this polynomial
     * @return a new polynomial representing the difference between the two
     *         polynomials
     */
    public Polynomial subtract(Polynomial p) {
        int maxDegree = Math.max(this.degree, p.getDegree());
        ArrayList<Double> resultCoefficients = new ArrayList<>();

        for (int i = 0; i <= maxDegree; i++) {
            double coeff1 = (i < this.coefficients.size()) ? this.coefficients.get(i) : 0.0;
            double coeff2 = (i < p.coefficients.size()) ? p.coefficients.get(i) : 0.0;
            resultCoefficients.add(coeff1 - coeff2);

        }

        return new Polynomial(resultCoefficients);
    }

    /**
     * Updates the degree of the polynomial by removing trailing zero coefficients.
     */
    private void updateDegree() {
        int maxDegree = 0; // Initialize the max degree to 0

        for (int i = this.coefficients.size() - 1; i >= 0; i--) {
            if (this.coefficients.get(i) != 0) {
                maxDegree = i;
                break;
            }
        }

        degree = maxDegree;

    }

    /**
     * Evaluates the polynomial at a given value of x.
     * 
     * @param x the value to evaluate the polynomial at
     * @return the result of the evaluation
     */
    public double evaluate(double x) {
        double result = 0.0;

        for (int i = 0; i < this.coefficients.size(); i++) {
            result += this.coefficients.get(i) * Math.pow(x, i);
        }

        return result;
    }

    /**
     * Resets the polynomial to the zero polynomial.
     * All coefficients are cleared, and the polynomial is set to 0.
     */
    public void clear() {
        this.coefficients = new ArrayList<>();
        this.coefficients.add(0.0);
        this.degree = 0;
    }

    /**
     * Returns the string representation of the polynomial.
     * 
     * @return the string representation of the polynomial
     */
    @Override
    public String toString() {

        if (degree == 0 && coefficients.get(0) == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
            double coeff = coefficients.get(i);
            if (coeff == 0) { // skip zero coefficients
                continue;
            }

            if (sb.length() > 0) {
                sb.append(coeff > 0 ? " + " : " - ");
            } else if (coeff < 0) {
                sb.append("-");
            }

            double absCoeff = Math.abs(coeff);
            if (absCoeff != 1 || i == 0) {
                sb.append(absCoeff);
            }

            if (i > 0) {
                sb.append("x");
                if (i > 1) {
                    sb.append("^").append(i);
                }
            }
        }

        return sb.toString();

    }

    /**
     * Compares this polynomial to another polynomial.
     * 
     * @param otherPolynomial the polynomial to compare against
     * @return 0 if equal, 1 if greater, -1 if less
     */
    @Override
    public int compareTo(Polynomial otherPolynomial) {
        // Case 1: Check if all coefficients are the same

        if (this.coefficients.equals(otherPolynomial.coefficients)) {
            return 0; // The polynomials are equal
        }

        // Case 2: Compare degrees

        if (this.degree > otherPolynomial.degree) {
            return 1; // Current polynomial has a higher degree
        } else if (this.degree < otherPolynomial.degree) {
            return -1; // Current polynomial has a lower degree
        }

        // Case 3: Degree are the same, compare evaluations at x = 1 and x = -1

        double thisValueAt1 = this.evaluate(1.0);
        double otherValueAt1 = otherPolynomial.evaluate(1.0);

        if (thisValueAt1 > otherValueAt1) {
            return 1; // Current polynomial has a higher value at x = 1
        } else if (thisValueAt1 < otherValueAt1) {
            return -1; // Current polynomial has a lower value at x = 1
        }

        double thisValueAtMinus1 = this.evaluate(-1.0);
        double otherValueAtMinus1 = otherPolynomial.evaluate(-1.0);

        if (thisValueAtMinus1 > otherValueAtMinus1) {
            return 1; // Current polynomial has a higher value at x = -1
        } else if (thisValueAtMinus1 < otherValueAtMinus1) {
            return -1; // Current polynomial has a lower value at x = -1
        }

        // If else fails, (which should not happen) return 0

        return 0;

    }

}
