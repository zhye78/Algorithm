package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2005_파스칼의삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append("\n");
			
			int N = Integer.parseInt(br.readLine());
			int[][] triangle = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<=i; j++) {
					if(j == 0 || j == i) {
						triangle[i][j] = 1;
						sb.append(1).append(" ");
					}
					else {
						triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
						sb.append(triangle[i][j]).append(" ");
					}
				}
				sb.append("\n");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb);
		}
		
	}

}
