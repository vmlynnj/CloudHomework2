package model;

import java.util.ArrayList;

public class PerfectThread implements Runnable {
	private int upper;
	private int lower;
	
	public static ArrayList<Integer> perfects = new ArrayList<Integer>();
	
	public PerfectThread(int upper, int lower) {
		this.upper = upper;
		this.lower = lower;
	}
	
	
	@Override
	public void run() {
		PerfectNumber generator = new PerfectNumber(this.upper, this.lower);
		int[] perfects = generator.findPerfects();
		int next = 0;
		while(perfects[next] != 0) {
			System.out.println("HERE");
			PerfectThread.perfects.add(perfects[next]);
			next++;
		}
	}

}
