package com.bhanu.dp;

public class LIS {

	public static int lis(int input[] ){
		int min = -10000;
		int including =1;
		int excluding =0;
		int includingElement = input[0];
		int excludingElement = min;
		int length =0;
		for(int i=1;i<input.length ;i++){
			if(input[i]>= includingElement){

				int temp = including;
				including = including+1;
				excluding = temp;
				excludingElement = includingElement;
				includingElement = input[i];
				int templength = Math.max(including, excluding);
				length = Math.max(templength, length);
				continue;
			}
			if(input[i] >= excludingElement){
				int temp = including;
				including = excluding +1;
				excluding = temp;
				excludingElement = includingElement;
				includingElement = input[i];
				int templength = Math.max(including, excluding);
				length = Math.max(templength, length);
				
				continue;
			}
			if(excluding ==1){
				
				excludingElement = input[i];
			}
		}
		return length;
	}
	public static void main(String[] args) {
		int input[] =
//			{10, 22, 9, 33, 21, 50, 41, 60, 80};
//					 {10, 22, 9, 33, 21, 50, 41, 60};
//			 {50,3,10,7,8,9};
//		{ 3, 7, 40, 80,};
//			{50,8,9,5,7,6,7,8,10,11};
			 {10, 22, 9, 33, 21, 50, 41, 120, 23, 70};
		System.out.println(lis(input));
	}
}
