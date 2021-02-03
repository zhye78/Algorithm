package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_농작물수확 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testCase; i++) {
			int N = Integer.parseInt(br.readLine());
			char[][] farm = new char[N][N];
			for(int j=0; j<N; j++)
				farm[j] = br.readLine().toCharArray();
			
			int sum = 0;
			//마름모 위쪽 계산
			for(int j=0; j<N/2+1; j++)
				for(int k=N/2-j; k<=N/2+j; k++)
					sum += Character.getNumericValue(farm[j][k]);
			//마름모 아래쪽 계산
			for(int j=N/2-1; j>=0; j--)
				for(int k=N/2-j; k<=N/2+j; k++)
					sum += Character.getNumericValue(farm[N-1-j][k]);
			
			System.out.println("#" + (i+1) + " " + sum);
		}
	}
}
