package model;

import java.util.ArrayList;
import java.util.Vector;

public class PerfectNumber {
	public static long upperLimit =10000;
	public static long lowerLimit = 0;
	
	public PerfectNumber() {
	}
	
	public PerfectNumber(long upperLimit, long lowerLimit) {
		PerfectNumber.upperLimit = upperLimit;
		PerfectNumber.lowerLimit = lowerLimit;
	}
	
	public Vector<Long> findPerfects() {
		System.out.println("HErE");
		Vector<Long> perfects = new Vector<Long>();
		int sum = 1;
		for(long i = lowerLimit; i<upperLimit; i+=2) {
			
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
		System.out.println("FINISH");
		return perfects;
	}
	
	public Vector<Long> findPerfectsTriangles() {
		System.out.println("HErE");
		Vector<Long> perfects = new Vector<Long>();
		long count = 1;
		long sum =1;
		long triangle = PerfectNumber.lowerLimit;
		while(triangle <=upperLimit) {
			triangle = (count*(count+1))/2;
			for(long i = 0; i<triangle; i++) {
				if(i%triangle==0) {
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
		/*
		for(long i = lowerLimit; i<upperLimit; i+=2) {
			
			triangle
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
		}*/
		return perfects;
	}
	
	public ArrayList<Integer> findPerfects(int upper, int lower) {
		System.out.println("HErE");
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
}
