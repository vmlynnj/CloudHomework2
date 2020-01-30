package main;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.PerfectNumberFinder;
import model.PerfectThread;

public class Main {
	public static final long LIMIT = (long) 3000000000.0; 
	public static long upper = 0;
	public static long lower =0;

	public static void main(String[] args) {
		int threadAmount = Integer.parseInt(args[0]);
		Thread[] pool = new Thread[threadAmount];
		PerfectNumberFinder finder = new PerfectNumberFinder();
		Vector<Long> perfects = new Vector<Long>();
		long increment = LIMIT/threadAmount;
		Main.lower = 0;
		Main.upper = increment;
		Runnable task = () -> perfects.addAll(finder.findPerfectsTriangles(Main.lower, Main.upper));
		long start_time = System.currentTimeMillis();
		for(int i=0; i<threadAmount; i++) {
			Thread thread = new Thread(task);
			pool[i] = thread;
			pool[i].start();
			Main.lower = Main.upper;
			Main.upper += increment;
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


