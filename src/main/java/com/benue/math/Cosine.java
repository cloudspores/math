package com.benue.math;

public class Cosine {

    /**
     * Generate matrix of cosine values in range defined by
     * supplied range.
     *
     * @param from starting value in degrees
     * @param to ending value in degrees
     * @param resolution number of data points in specified range
     * @return matrix of cosine values
     */
    public static double [] cosines(int from, int to, int resolution) {

        double [] results   = new double[resolution];
        double step         = (to-from)/(resolution-1);
        double index        = from;

        for(int i=0; i<resolution; i++) {
            results[i] = Math.cos(Math.toRadians(index));
            index+=step;
        }

        return results;
    }
}
