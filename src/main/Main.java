package main;

import java.util.Vector;

import model.PerfectNumberFinder;

/**
 *  The entry point of the application
 * @author Victoria Jenkins
 *
 */
public class Main {
	public static final long LIMIT = (long) 30000000.0; 

	/**
	 * The entry point to the application 
	 * @param args the amount of threads
	 */
	public static void main(String[] args) {
		int threadAmount = Integer.parseInt(args[0]);
		Thread[] pool = new Thread[threadAmount];
		PerfectNumberFinder finder = new PerfectNumberFinder();
		Vector<Long> perfects = new Vector<Long>();
		long[] upperBounds = Main.upperBounds(threadAmount);
		long[] lowerBounds = Main.lowerBounds(threadAmount, upperBounds);
		long start_time = System.currentTimeMillis();
		try {
			for (int i = 0; i < threadAmount; i++) {
				long lower = lowerBounds[i];
				long upper = upperBounds[i];
				Runnable task = () -> {
					perfects.addAll(finder.findPerfects(lower, upper));
				};
				Thread thread = new Thread(task);
				pool[i] = thread;
				pool[i].start();
				pool[i].join();
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
        long end_time = System.currentTimeMillis();
		long elapsed_time = (end_time - start_time);
		System.out.println("Elasped time: " + elapsed_time + " millis");
	}
	
	
	private static long[] upperBounds(int threadAmount) {
		long increment = LIMIT / threadAmount;
		long[] upperBounds = new long[threadAmount];
		upperBounds[0] = increment;
		for (int k = 1; k < threadAmount; k++) {
			upperBounds[k] = upperBounds[k - 1] + increment; 
		}
		return upperBounds;
	}
	
	private static long[] lowerBounds(int threadAmount, long[] upperBounds) {
		long[] lowerBounds = new long[threadAmount];
		lowerBounds[0] = 0;
		for (int k = 1; k < threadAmount; k++) {
			lowerBounds[k] = upperBounds[k - 1];
		}
		return lowerBounds;
	}
}


