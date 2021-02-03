package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int fly = Integer.parseInt(st.nextToken());
			int[][] area = new int[size][size];
			for(int j=0; j<size; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<size; k++) {
					area[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			for(int j=0; j<=size-fly; j++) {
				for(int k=0; k<=size-fly; k++) {
					//이 위치에서의 파리채 구역의 파리 합 구하기
					int count = 0;
					for(int a=0; a<fly; a++)
						for(int b=0; b<fly; b++)
							count += area[a+j][b+k];
					if(max < count)
						max = count;
				}
			} //for size
			
			System.out.println("#" + (i+1) + " " + max);
			
		} //for testCase
	} //main

}
