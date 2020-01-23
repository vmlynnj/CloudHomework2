package main;

import model.PerfectNumber;
import model.PerfectThread;

public class Main {

	public static void main(String[] args) {
		/*
		int threadAmount = Integer.parseInt(args[0]);
		Thread[] pool = new Thread[threadAmount];
		Thread thread1 = new Thread(new PerfectThread(0,5000));
		Thread thread2 = new Thread(new PerfectThread(5000,10000));
		
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
			int[] perfects = new int[500];
			thread1.getPerfects
		} catch (Exception ie) {
			
		}
		*
		
		
		for(int i = 0; i< threadAmount; i++) {
			Thread thread = new Thread(new PerfectThread());
		}
		*/
		PerfectNumber pfn = new PerfectNumber();
		int[] perfects = pfn.findPerfects();
		int next = 0;
		while (perfects[next] != 0) {
			System.out.print(perfects[next]);
			next++;
			if(perfects[next] != 0) {
				System.out.print(", ");
			}
		}
	}

}
