package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
			double sum = 0;
			if (n != 0) {
				sum = sum + 1/(Math.pow(2,n)) + geometricSum(n -1);
				return sum;
			}
			else {
				return 0;
			}
	}
		

	
	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius, double radiusMinimumDrawingThreshold) {
		if (radius >= radiusMinimumDrawingThreshold){
			StdDraw.circle(xCenter,yCenter,radius);
			circlesUponCircles(xCenter+radius, yCenter, radius/3.0,radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter,yCenter+radius,radius/3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter - radius, yCenter, radius/3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter,yCenter-radius,radius/3.0,radiusMinimumDrawingThreshold);
		}
		else{
			return;
		}
		
	}
	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
			int i = 0;
			int [] arrayR = new int [array.length];
			toReversedHelper(array,arrayR,i);
			return arrayR;
		
	}
	public static void toReversedHelper(int [] array, int [] arrayR,int i){
		if (i == array.length){
			return;
		}
		arrayR[array.length - 1 - i] = array[i];
		toReversedHelper(array,arrayR,i+1);
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if (q == 0){
			return p;
		}
		return gcd(q,p % q);
	}
	public static void gcdHelper(int p, int q, int n){
			if (p % n == 0 && q % n == 0){
				return;
			}
			gcdHelper(p,q,n-1);
	}


}