package main;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.PerfectNumber;
import model.PerfectThread;

public class Main {

	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<Integer>();
		PerfectNumber pfn = new PerfectNumber();
		/*
		Runnable runny1 = () -> {
			vector.addAll(pfn.findPerfects(0,5000));
		};
		Runnable runny2 = () -> {
			vector.addAll(pfn.findPerfects(5000,10000));
		};
		
		*/
		Runnable runny1 = new PerfectThread(000,5000);
		Runnable runny2 = new PerfectThread(5000,10000);
		ExecutorService pool = Executors.newFixedThreadPool(2); 

		
		pool.execute(runny1);
		pool.execute(runny2);
		
		
		pool.shutdown();
		/*
		Thread t = new Thread(runny1);
		t.start();
		
		
		//int threadAmount = Integer.parseInt(args[0]);
		//Thread[] pool = new Thread[threadAmount];
		/*
		PerfectThread pt1 = new PerfectThread(0,5000);
		PerfectThread pt2 = new PerfectThread(5000,10000);
		
		Thread thread1 = new Thread(pt1);
		Thread thread2 = new Thread(pt2);
		
		
		thread1.start();
		thread2.start();
		
		try {
			//thread1.join(0);
			//thread2.join(0);
			t.join();
		} catch (Exception ie) {
			
		}
		*/
		
		System.out.println("Size: "+vector);
		
		for(int curr: vector) {
			System.out.println(curr + " ");
		}
		/*
		PerfectNumber pfn = new PerfectNumber();
		ArrayList<Integer> perfects = pfn.findPerfects();
		int next = 0;
		for(Integer curr : perfects) {
			System.out.print(curr + ", ");
			next++;
			}
			*/
		}
		
		
	}


