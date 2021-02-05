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
			int maxVal = prices[day-1]; //max값을 맨 뒤 값으로 초기화
			long purchase = 0; //소비
			long total = 0;
			for(int i=day-2; i>=0; i--) {
				if(prices[i] <maxVal) {
					purchase += prices[i];
					count++;
				}else {
					total += maxVal * count - purchase;
					//System.out.println(maxVal+" "+count+" "+purchase);
					//System.out.println("total: " + total);
					maxVal = prices[i];
					count = 0;
					purchase = 0;
				}
			}
			//System.out.println(maxVal+" "+count+" "+purchase);
			//System.out.println("total: " + total);
			total += maxVal * count - purchase;
			System.out.println("#" + tc + " " + total);
		}
	}

}
