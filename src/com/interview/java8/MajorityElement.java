package com.interview.java8;

public class MajorityElement {

	 public static int findMajorityElement(int[] nums) {
		 int candidate=0;
		 int count=0;
		 
		 for(int i:nums) {
			 
			 if(count==0) {
				 candidate=i;
				 count=1;
			 }else if(i==candidate) {
				 count++;
			 }else
				 count--;
		 }
		 
		 count=0;
		 for(int i:nums) {
			 if(i==candidate)
				 count++;
		 }
		 
		 if(count>nums.length/2)
		 return candidate;
		 return -1;
	 }
	 
	 public static void main(String[] args) {
		 int[] nums = {3, 3, 4, 2, 4, 4, 2, 4, 4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5} ;
		 int majorityElement = findMajorityElement(nums);
		 
		 if (majorityElement != -1) {
	            System.out.println("Majority element: " + majorityElement);
	        } else {
	            System.out.println("No majority element found.");
	        }
	}
}
