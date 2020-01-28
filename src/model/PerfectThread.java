package model;

import java.util.ArrayList;
import java.util.Vector;

public class PerfectThread implements Runnable {
	private int upper;
	private int lower;
	
	public static final Vector<Long> perfects = new Vector<Long>();
	
	public PerfectThread(int upper, int lower) {
		this.upper = upper;
		this.lower = lower;
	}
	
	
	@Override
	public synchronized void run() {
		System.out.println("here upper: "+ this.upper + " lower: "+ this.lower);
		PerfectNumberFinder generator = new PerfectNumberFinder(this.upper, this.lower);
		Vector<Long> perfects = generator.findPerfects();
		for(Long curr: perfects) {
			System.out.println("HERE");
			PerfectThread.perfects.add(curr);
		}
		System.out.println("Finished "+ this.upper);
	}

}
