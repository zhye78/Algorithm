package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	static int N;
	static int M;
	static List<int[]> chickenList;
	static List<int[]> houseList;
	static int minVal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		houseList = new ArrayList<>();
		chickenList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 1)
					houseList.add(new int[] {i+1, j+1});
				else if(n == 2)
					chickenList.add(new int[] {i+1, j+1});
			}
		}
		
		int[][] temp = new int[M][2];
		minVal = Integer.MAX_VALUE;
		combination(0, 0, temp);
		System.out.println(minVal);
	}
	
	public static void combination(int current, int start, int[][] temp) {
		if(current == M) {
			int val = 0;
			for(int i=0; i<houseList.size(); i++) {
				int[] house = houseList.get(i);
				int count = Integer.MAX_VALUE;
				for(int j=0; j<temp.length; j++) {
					int a = Math.abs(house[0] - temp[j][0]) + Math.abs(house[1] - temp[j][1]);
					if(count > a)
						count = a;
				}
				val += count;
			}
			
			if(minVal > val) minVal = val;
			return;
		}
		
		for(int i=start; i<chickenList.size(); i++) {
			temp[current] = chickenList.get(i);
			combination(current+1, i+1, temp);
		}
	}
}
