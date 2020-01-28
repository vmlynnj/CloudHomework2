package main;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.PerfectNumberFinder;
import model.PerfectThread;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println("1 000 000 2 threads");
		long start_time = System.currentTimeMillis();
		PerfectNumberFinder finder = new PerfectNumberFinder();
		Vector<Long> perfects = new Vector<Long>();
		Object lock = new Object();
		Runnable run1 = () -> {
			Vector<Long> perfectsRun1 = finder.findPerfectsTriangles(0,500000);
			synchronized(lock) {
				perfects.addAll(perfectsRun1);
			}
			
		};
		Runnable run2 = () -> {
			Vector<Long> perfectsRun2 = finder.findPerfectsTriangles(500000, 1000000);
			synchronized(lock) {
				perfects.addAll(perfectsRun2);
			}
		};
		
		Thread t1 = new Thread(run1);
		Thread t2 = new Thread(run2);
		t1.run();
		t2.run();
		try {
			t1.join();
			t2.join();
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
		
		/* no thread test
		System.out.println("100 000 000");
		long start_time = System.currentTimeMillis();
		PerfectNumberFinder finder = new PerfectNumberFinder(0,100000000);
		Vector<Long> perfects = finder.findPerfectsTriangles();
		
        long end_time = System.currentTimeMillis();

		long elapsed_time = (end_time - start_time);
		
		System.out.println("Elasped time: "+ elapsed_time + " millis");
		
		System.out.println("Size: "+perfects.size());
		
		for(long curr: perfects) {
			System.out.println(curr + " ");
		}
		*/
		
		
		
		
		
		}
		
		
	}


