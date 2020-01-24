package model;

import java.util.ArrayList;

public class PerfectThread implements Runnable {
	private int upper;
	private int lower;
	
	public static final ArrayList<Integer> perfects = new ArrayList<Integer>();
	
	public PerfectThread(int upper, int lower) {
		this.upper = upper;
		this.lower = lower;
	}
	
	
	@Override
	public synchronized void run() {
		System.out.println("here upper: "+ this.upper + " lower: "+ this.lower);
		PerfectNumber generator = new PerfectNumber(this.upper, this.lower);
		ArrayList<Integer> perfects = generator.findPerfects();
		for(Integer curr: perfects) {
			System.out.println("HERE");
			PerfectThread.perfects.add(curr);
		}
		System.out.println("Finished "+ this.upper);
	}

}
