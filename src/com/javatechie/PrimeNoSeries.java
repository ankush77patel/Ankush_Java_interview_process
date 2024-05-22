package com.javatechie;

public class PrimeNoSeries {

	
	public static void main(String[] args) {
	System.out.println(generatedPrimeNo(25));
	}
	
	private static String generatedPrimeNo(int num) {
		StringBuilder primeNOSeries=new StringBuilder();
		boolean isPrime;
		for(int i=1;i<num;i++) {
			isPrime=true;
			for(int j=2;j<i;j++) 
			if(i%j==0)
				isPrime=false;
			if(isPrime) 
			primeNOSeries.append(i).append(" ");
			
		
				
		}
		return primeNOSeries.toString();
	}
}
