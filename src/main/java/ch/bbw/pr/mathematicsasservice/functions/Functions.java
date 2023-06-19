package ch.bbw.pr.mathematicsasservice.functions;

import static java.lang.Math.*;

/**
 * Functions to calculate some physical formulas
 *
 * @author Peter Rutschmann
 * @version 11.06.2023
 */
public class Functions {
    /**
     * Calculate flyingTime
     *
     * @param v0    in mm/s
     * @param theta in Grad
     * @return time in s
     */
    public short flyingTime(int v0, int theta) {
        double theta_rad = toRadians(theta);
        double g = 9.81;
        System.out.println("Functions.flyingTime: " + ((2 * v0 * sin(theta_rad)) / g));
        return (short) ((2 * v0 * sin(theta_rad)) / g);
    }

    /**
     * Calculate flyingHeight
     *
     * @param v0    in mm/s
     * @param theta in Grad
     * @return height in mm
     */
    public short flyingHeight(int v0, int theta) {
        double theta_rad = toRadians(theta);
        double g = 9.81;
        System.out.println("Functions.flyingHeight " + sqrt(32767 * g / sin(2 * theta_rad)));
        System.out.println("Functions.flyingHeight: " + ((pow(v0, 2) * sin(2 * theta_rad)) / g));
        return (short) ((pow(v0, 2) * sin(2 * theta_rad)) / g);
    }

    /**
     * Calculate flying width
     *
     * @param v0    initial velocity in mm/s
     * @param theta launch angle in degrees
     * @return width in mm
     */
    public double flyingWidth(int v0, int theta) {
        double theta_rad = Math.toRadians(theta);
        double g = 9.81;

        double timeOfFlight = (2 * v0 * Math.sin(theta_rad)) / g;
        double flyingWidth = v0 * Math.cos(theta_rad) * timeOfFlight;

        System.out.println("Functions.flyingWidth: " + flyingWidth);
        return flyingWidth;
    }


    /*-------------------------------------------------------------------------------
     * Functions to show the problems.
     */

    /**
     * addition not validated
     *
     * @param a
     * @param b
     * @return a+b
     */
    public int unsafeAddition(int a, int b) {
        return a + b;
    }

    /**
     * save addition
     *
     * @param a
     * @param b
     * @return a+b
     * @throws ArithmeticException in case of overflow
     */
    public int safeAddition(int a, int b) throws ArithmeticException {
        long result = (long) a + (long) b;
        if (result > Integer.MAX_VALUE) {
            throw new ArithmeticException("Value overflow.");
        }
        return a + b;
    }

    /**
     * division not validated
     *
     * @param a
     * @param b
     * @return a / b
     */
    public double unsafeDivision(int a, int b) {
        return a / b;
    }

    /**
     * save division
     *
     * @param a
     * @param b
     * @return
     */
    public double safeDivision(int a, int b) {
        //TODO noch nicht fertig implementiert
        return a / b;
    }
}
