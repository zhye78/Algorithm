package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839_설탕배달 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		int answer = 0;
		
		while(n >= 0) {
			if(n % 5 == 0) {
				answer = n / 5 + count;
				break;
			}
			n -= 3;
			count += 1;
		}
		
		if(n < 0)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
}
