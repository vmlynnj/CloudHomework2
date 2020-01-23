package model;

public class PerfectNumber {
	public static int upperLimit =1000000;
	public static int lowerLimit = 0;
	
	public PerfectNumber() {
	}
	
	public PerfectNumber(int upperLimit, int lowerLimit) {
		PerfectNumber.upperLimit = upperLimit;
		PerfectNumber.lowerLimit = lowerLimit;
	}
	
	public int[] findPerfects() {
		int[] perfects = new int[upperLimit/8];
		int currIndex = 0;
		int sum = 1;
		for(int i = lowerLimit; i<upperLimit; i+=2) {
			for (int j=2; j< i ; j++) {
				if(i % j == 0 ) {
					sum +=  j;
				}
			}
			if(sum == i) {
				perfects[currIndex] = i;
				currIndex ++;
			}
		}
		return perfects;
	}
	

}
