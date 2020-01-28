package main;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.PerfectNumberFinder;
import model.PerfectThread;

public class Main {

	public static void main(String[] args) {
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
		
		
		//Threads  1M
		/*
		System.out.println("10 000 000");
		long start_time2 = System.currentTimeMillis();
		PerfectNumberFinder finder2 = new PerfectNumberFinder(0, 10000000);
		Vector<Long> perfects2 = finder2.findPerfectsTriangles();
		
        long end_time2 = System.currentTimeMillis();

		long elapsed_time2 = (end_time2 - start_time2);
		
		System.out.println("Elasped time: "+ elapsed_time2 + " millis");
		
		System.out.println("Size: "+perfects2.size());
		
		for(long curr: perfects2) {
			System.out.println(curr + " ");
		}*/
		
		//Threads 10M
		
		
		
		
		}
		
		
	}


