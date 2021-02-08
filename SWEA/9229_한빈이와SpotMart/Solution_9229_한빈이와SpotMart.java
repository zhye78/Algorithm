package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {
	/*static int[] snacks;
	static int num;
	static int limit;
	static int maxSum;*/
	
	/*public static void combination(int n, int current, int start, int curSum) {
		if(curSum > limit)
			return;
		if(current == n) 
			maxSum = Math.max(maxSum, curSum);
		for(int i=0; i<num; i++)
			combination(n, current+1, i+1, curSum+snacks[i]);
	}*/

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			int[] snacks = new int[num];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<num; i++)
				snacks[i] = Integer.parseInt(st.nextToken());
			
			int maxSum = 0;
			//combination(2, 0, 0, 0);
			Arrays.sort(snacks);
			for(int i=0; i<num; i++) {
				for(int j=0; j<num; j++) {
					if(i == j) continue; //같은 봉지를 두 번 들 수 없다.
					if(snacks[i] + snacks[j] > limit)
						break;
					maxSum = Math.max(maxSum, snacks[i] + snacks[j]);
				}
			}
			
			sb.append("#" + tc + " ");
			if(maxSum == 0)
				sb.append(-1);
			else
				sb.append(maxSum);
			System.out.println(sb);
		}
		
		br.close();
	}

}
