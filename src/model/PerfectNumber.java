package model;

import java.util.ArrayList;

public class PerfectNumber {
	public static int upperLimit =10000;
	public static int lowerLimit = 0;
	
	public PerfectNumber() {
	}
	
	public PerfectNumber(int upperLimit, int lowerLimit) {
		PerfectNumber.upperLimit = upperLimit;
		PerfectNumber.lowerLimit = lowerLimit;
	}
	
	public ArrayList<Integer> findPerfects() {
		System.out.println("HErE");
		ArrayList<Integer> perfects = new ArrayList<Integer>();
		int sum = 1;
		for(int i = lowerLimit; i<upperLimit; i+=2) {
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
