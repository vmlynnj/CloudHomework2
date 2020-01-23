package model;

public class PerfectThread implements Runnable {
	private int upper;
	private int lower;
	
	private int[] perfects;
	
	public PerfectThread(int upper, int lower) {
		this.upper = upper;
		this.lower = lower;
	}
	
	public int[] getPerfects() {
		return this.perfects;
	}
	
	@Override
	public void run() {
		PerfectNumber generator = new PerfectNumber(this.upper, this.lower);
		this.perfects = generator.findPerfects();
	}

}
