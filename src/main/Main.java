package main;

import java.util.ArrayList;

import model.PerfectNumber;
import model.PerfectThread;

public class Main {

	public static void main(String[] args) {
		
		//int threadAmount = Integer.parseInt(args[0]);
		//Thread[] pool = new Thread[threadAmount];
		PerfectThread pt1 = new PerfectThread(0,5000);
		PerfectThread pt2 = new PerfectThread(5000,10000);
		
		Thread thread1 = new Thread(pt1);
		Thread thread2 = new Thread(pt2);
		
		thread1.start();
		thread2.start();
		try {
			thread1.join(0);
			thread2.join(0);

			
		} catch (Exception ie) {
			
		}
		
		
		System.out.print("Size: "+PerfectThread.perfects.size());
		
		for(int curr: PerfectThread.perfects) {
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


