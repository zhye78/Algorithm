package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	
	static int N; //전체 고객의 수
	static int companyX;
	static int companyY;
	static int homeX;
	static int homeY;
	static int[][] customers; //전체 고객들의 좌표들
	static int minCost;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			companyX = Integer.parseInt(st.nextToken());
			companyY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			
			customers = new int[N][2];
			for(int i=0; i<N; i++) {
				customers[i][0] = Integer.parseInt(st.nextToken());
				customers[i][1] = Integer.parseInt(st.nextToken());
			}
			
			minCost = Integer.MAX_VALUE;
			boolean[] selected = new boolean[N];
			int[][] temp = new int[N][2];
			check(0, selected, temp);
			System.out.println("#" + tc + " " + minCost);
		}
	}

	private static void check(int current, boolean[] selected, int[][] temp) {
		if(current == N) { //고객 방문 순서가 완성되었다면
			int cost = 0;
			cost += Math.abs(companyX - temp[0][0]) + Math.abs(companyY - temp[0][1]); //회사에서 첫 고객까지
			for(int i=0; i<N-1; i++)
				cost += Math.abs(temp[i][0] - temp[i+1][0]) + Math.abs(temp[i][1] - temp[i+1][1]);
			cost += Math.abs(temp[N-1][0] - homeX) + Math.abs(temp[N-1][1] - homeY); //마지막 고객에서 집까지
			if(cost < minCost)
				minCost = cost;
		}
		for(int i=0; i<N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				temp[current][0] = customers[i][0];
				temp[current][1] = customers[i][1];
				check(current+1, selected, temp);
				selected[i] = false;
			}
		}
	}
}
