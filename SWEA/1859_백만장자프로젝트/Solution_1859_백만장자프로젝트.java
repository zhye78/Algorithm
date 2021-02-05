package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859_백만장자프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=testCase; tc++) {
			int day = Integer.parseInt(br.readLine());
			int[] prices = new int[day];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<day; i++)
				prices[i] = Integer.parseInt(st.nextToken());

			int count = 0; //소비한 개수
			int purchase = 0; //소비
			int total = 0;
			for(int i=0; i<day; i++) {
				if(i == day-1) {
					total += prices[i] * count - purchase;
					break;
				}
				if(prices[i] <= prices[i+1]) {
					purchase += prices[i];
					count++;
				}else {
					total += prices[i] * count - purchase;
					purchase = 0;
					count = 0;
				}
			}
			
			System.out.println("#" + tc + " " + total);
		}
	}

}
