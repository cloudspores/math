package com.benue.math;

public class ChebyshevFirstKind {

    /**
     * Construct a table of Chebyshev Polynomial Coefficients
     * up to the supplied degree
     *
     * @param degree required max degree
     * @return results matrix populated with coefficient values
     */
    public static int[][] coefficients(int degree) {

        int [][] results = new int[degree+1][degree+1];

        results[0][0] = 1;
        results[1][1] = 1;

        for(int p=1; p<degree; p++) {
            for(int q=0; q<degree; q++) {

                // Evaluate all elements in the first column
                results[p+1][0] = -results[p-1][0];

                // Calculate rest of elements using the recursive formula
                results[p+1][q+1] = results[p][q] * 2 - results[p-1][q+1];
            }
        }

        return results;
    }

    /**
     * Evaluate a Chebyshev of first kind polynomial over unit range,
     * using Horner's Method in O(n) time.
     *
     * @param degree degree of polynomial
     * @param resolution number of data points per unit range
     * @param coefficients table of coefficients
     * @return matrix of evaluated polynomial over unit range
     */
    public static double[] polynomial(int degree, int resolution, int[][] coefficients) {

        double [] results = new double[resolution];

        double x = -1;
        for(int index=0; index<resolution; index++) {

            double step = 2.0/(resolution-1);

            // Evaluate value of polynomial for x
            // Horner’s method can be used to evaluate polynomial in O(n) time.
            results[index] = eval(x, coefficients[degree]);

            x+=step;
        }

        return results;
    }

    /**
     * Evaluate a Chebyshev of first kind polynomial over unit range,
     * using Horner's Method in O(n) time mapping results with supplied x values
     *
     * @param degree degree of polynomial
     * @param resolution number of data points per unit range
     * @param coefficients table of coefficients
     * @param x range of values x to compute - must be of length resolution
     * @return matrix of evaluated polynomial over unit range
     */
    public static double[] polynomial(int degree, int resolution, int[][] coefficients, double[]x) {

        double [] results = new double[resolution];

        for(int index=0; index<resolution; index++) {

            // Evaluate value of polynomial for x
            // Horner’s method can be used to evaluate polynomial in O(n) time.
            results[index] = eval(x[index], coefficients[degree]);
        }

        return results;
    }

    /**
     * Evaluate a Chebyshev of first kind polynomial for each degree supplied
     * over unit range using Horner's Method in O(n) time mapping results with supplied x values
     *
     * @param weightings array containing list of weightings in order of corresponding degree of polynomials to evaluate
     * @param resolution number of data points per unit range
     * @param coefficients table of coefficients
     * @param x range of values x to compute - must be of length resolution
     * @return matrix of evaluated polynomial over unit range
     */
    public static double[] polynomial(int[] weightings, int resolution, int[][] coefficients, double[]x) {

        double [] resultsReduced = new double[resolution];

        int degree=1;
        for (int aWeighting : weightings) {

            double[] results = polynomial(degree++, resolution, coefficients, x);

            int i=0;
            for(double aResults : results) {
                resultsReduced[i++]+=(aResults*aWeighting);
            }
        }

        return resultsReduced;
    }

    /**
     * Use Horner's method to compute (in O(n) time)
     * and return the polynomial evaluated at x
     *
     * p[0] + p[1] x^1 + p[2] x^2 + ... + p[n-1] x^n-1
     *
     * @param x value to evaluate
     * @param p table of coefficients
     * @return computed value
     */
    public static double eval(double x, int[] p) {

        double result = 0;
        for (int i = p.length - 1; i >= 0; i--) {
            result = p[i] + (x * result);
        }

        return result;
    }
}