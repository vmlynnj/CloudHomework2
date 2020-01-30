package main;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.PerfectNumberFinder;
import model.PerfectThread;

public class Main {
	public static final long LIMIT = (long) 30000.0; 

	public static void main(String[] args) {
		int threadAmount = Integer.parseInt(args[0]);
		Thread[] pool = new Thread[threadAmount];
		Object lock  = new Object();
		PerfectNumberFinder finder = new PerfectNumberFinder();
		Vector<Long> perfects = new Vector<Long>();
		long increment = LIMIT/threadAmount;

		
		long start_time = System.currentTimeMillis();
		long[] upperBounds = new long[threadAmount];
		long[] lowerBounds = new long[threadAmount];
		lowerBounds[0] = 0;
		upperBounds[0] = increment;
		for(int k = 1; k<threadAmount; k++) {
			lowerBounds[k] =upperBounds[k-1];
			upperBounds[k] = upperBounds[k-1] + increment; 
		}
		
		
		for(int i=0; i<threadAmount; i++) {
			Runnable task = () -> {
				System.out.println("BOUNDS:: Lower: "+ lowerBounds[i] + " Upper: "+ upperBounds[i]);
				perfects.addAll(finder.findPerfectsTriangles(lowerBounds[i], upperBounds[i]));
			
			};
			Thread thread = new Thread(task);
			pool[i] = thread;
			pool[i].start();
			System.out.println("BOUNDS:: Lower: "+ lowerBounds[i] + " Upper: "+ upperBounds[i]);
		}
		
		try {
			for(int j = 0; j < threadAmount; j++) {
				pool[j].join();
			}
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
        long end_time = System.currentTimeMillis();

		long elapsed_time = (end_time - start_time);
		
		System.out.println("Elasped time: "+ elapsed_time + " millis");
		
		System.out.println("Size: "+perfects.size());
		
		for(long curr: perfects) {
			System.out.println(curr + " ");
		}
		
		
		
		
		
		
		}
		
		
	}


