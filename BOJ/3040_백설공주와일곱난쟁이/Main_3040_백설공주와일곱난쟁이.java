package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_3040_백설공주와일곱난쟁이 {
	
	static int[] all;
	static int[] seven;
	static int[] temp;
	static int r = 7;
	
	public static void combination(int start, int current) {
		if(current == r) {
			int sum = 0;
			for(int i=0; i<temp.length; i++)
				sum += temp[i];
			if(sum == 100)
				seven = Arrays.copyOf(temp, r);
			return;
		}
		for(int i=start; i<all.length; i++) {
			temp[current] = all[i];
			combination(i+1, current+1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		all = new int[9];
		seven = new int[r];
		for(int i=0; i<9; i++)
			all[i] = Integer.parseInt(br.readLine());
		
		temp = new int[r];
		combination(0, 0);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<seven.length; i++)
			sb.append(seven[i]).append("\n");
		System.out.println(sb);
	}

}
