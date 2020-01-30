package model;

import java.util.ArrayList;
import java.util.Vector;

public class PerfectNumberFinder {
	private long upperLimit;
	private long lowerLimit;
	
	public PerfectNumberFinder() {
		this.upperLimit = 10000;
		this.lowerLimit = 0;
	}
	
	public PerfectNumberFinder(long lowerLimit, long upperLimit) {
		this.upperLimit = upperLimit;
		this.lowerLimit = lowerLimit;
	}
	
	public Vector<Long> findPerfects() {
		Vector<Long> perfects = new Vector<Long>();
		int sum = 1;
		for(long i = this.lowerLimit; i<this.upperLimit; i+=2) {
			
			for (long j=2; j< i ; j++) {
				if(i % j == 0 ) {
					sum +=  j;
				}
				if(sum > i) {
					j = i+1;
				}
			}
			if(sum == i) {
				perfects.add(i);
			}
			sum = 1;
		}
		return perfects;
	}
	
	public synchronized Vector<Long> findPerfectsTriangles(long lower, long upper) {
		Vector<Long> perfects = new Vector<Long>();
		long count = 2;
		long sum =1;
		long triangle = lower;
		while(triangle <= upper) {
			triangle = (count*(count+1))/2;

			for(long i = 2; i<triangle; i++) {
				if(triangle%i==0) {
					sum += i;
				}
				if(sum >triangle) {
					i = triangle+1;
				}
			}
			if(sum == triangle) {
				perfects.add(triangle);
			}
			
			sum = 1;
			count++;
					
		}
		return perfects;
	}
	
	public ArrayList<Integer> findPerfects(int upper, int lower) {
		ArrayList<Integer> perfects = new ArrayList<Integer>();
		int sum = 1;
		for(int i = lower; i<upper; i+=2) {
			for (int j=2; j< i ; j++) {
				if(i % j == 0 ) {
					sum +=  j;
				}
				if(sum > i) {
					j = i+1;
				}
			}
			if(sum == i) {
				perfects.add(i);
			}
			sum = 1;
		}
		System.out.println("FINISH");
		return perfects;
	}
	
	public Vector<Long> findTriangles() {
		Vector<Long> triangleNumbers = new Vector<Long>();
		long count = 2;
		long triangle = this.lowerLimit;
		while(triangle <= this.upperLimit) {
			triangle = (count*(count+1))/2;
			triangleNumbers.add(triangle);
			count++;
		}
		return triangleNumbers;
	}
	
	public boolean isPerfect(long number) {
		long sum =1;

		for(long i = 2; i<number; i++) {
			if(number%i==0) {
				sum += i;
			}
			if(sum > number) {
				i = number+1;
			}
		}
		return (sum == number);
	}
}
