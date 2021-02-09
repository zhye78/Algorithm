package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_1로만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		arr[1] = 0;
		int minVal = Integer.MAX_VALUE;
		for(int i=2; i<n+1; i++) {
			minVal = arr[i-1] + 1;
			if(i % 3 == 0)
				minVal = Math.min(minVal, arr[i/3] + 1);
			if(i % 2 == 0)
				minVal = Math.min(minVal, arr[i/2] + 1);
			arr[i] = minVal;
		}
		
		System.out.println(arr[n]);
	}

}
