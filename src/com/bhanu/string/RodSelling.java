package com.bhanu.string;

public class RodSelling {

	public static int maxProfite(int [] price){
		int length = price.length;
		int maxPrice[] = new int [length];
		maxPrice = price;
		for(int i=1;i<length;i++){
			for(int k=0;k<i;k++){
				int temp =  maxPrice[i-k];
				int temp1 = maxPrice[k];
				maxPrice[i] = Math.max(price[i],temp1+temp);
			}
		}
		
		return maxPrice[price.length-1];
	}
	
	public static void main(String[] args) {
		int price [] = {0, 1 ,5 ,8,9 ,10, 17,17,20};
		System.out.println(maxProfite(price));
	}
}
