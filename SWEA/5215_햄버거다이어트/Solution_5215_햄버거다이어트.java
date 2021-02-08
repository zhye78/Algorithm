package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트 {
	static int maxScore;
	static int[] calories;
	static int[] scores;
	static int num;
	static int cal;
	
	private static void makeSet(boolean[] isTrue, int idx, int currentCal) {
		if(currentCal > cal)
			return;
		if(idx == num) {
			int sum = 0;
			for(int i=0; i<num; i++) {
				if(isTrue[i])
					sum += scores[i];
			}
			maxScore = Math.max(maxScore, sum);
			return;
		}
		
		isTrue[idx] = true;
		makeSet(isTrue, idx+1, currentCal + calories[idx]); //현재 칼로리 포함!!!currentCal에 현재 칼로리를 더해서 재귀호출
		isTrue[idx] = false;
		makeSet(isTrue, idx+1, currentCal); //현재 칼로리 불포함!!!
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			cal = Integer.parseInt(st.nextToken());
			
			scores = new int[num]; //각 재료의 점수 저장
			calories = new int[num]; //각 재료의 칼로리 저장
			for(int i=0; i<num; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}
			
			maxScore = 0;
			boolean[] isTrue = new boolean[num];
			makeSet(isTrue, 0, 0);
			
			System.out.println("#" + tc + " " + maxScore);
		}
	}
}
