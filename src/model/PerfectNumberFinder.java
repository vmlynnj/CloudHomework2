package model;

import java.util.Vector;

/**
 * Finds perfect numbers
 * @author Victoria Jenkins
 *
 */
public class PerfectNumberFinder {
	
	/**
	 *  Finds perfect numbers within the given parameters
	 * @param lower the lower bounds
	 * @param upper the upper bounds
	 * @return a list of perfect numbers within the given range
	 */
	public Vector<Long> findPerfects(long lower, long upper) {
		Vector<Long> perfects = new Vector<Long>();
		Vector<Long> triangles = this.findTriangleNumbers(lower, upper);
		for (Long current : triangles) {
			if (this.isPerfect(current)) {
				perfects.add(current);
			}
		}
		return perfects;
	}
	
	
	private Vector<Long> findTriangleNumbers(long lower, long upper) {
		Vector<Long> triangleNumbers = new Vector<Long>();
		long count = 2;
		long triangle = lower;
		while (triangle <= upper) {
			triangle = (count * (count + 1)) / 2;
			triangleNumbers.add(triangle);
			count++;
		}
		triangleNumbers.removeIf(n -> n <= lower);
		triangleNumbers.removeIf(n -> n >= upper);
		return triangleNumbers;
	}
	
	private boolean isPerfect(long number) {
		long sum = 1;

		for (long i = 2; i < number; i++) {
			if (number % i == 0) {
				sum += i;
			}
			if (sum > number) {
				i = number + 1;
			}
		}
		return (sum == number);
	}
}
