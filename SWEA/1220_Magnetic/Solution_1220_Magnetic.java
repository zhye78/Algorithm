package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1220_Magnetic {
	static int len;
	static int[][] table;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			len = Integer.parseInt(br.readLine());
			table = new int[len][len];
			
			for(int i=0; i<len; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<len; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			for(int i=0; i<len; i++) {
				boolean isN = false;
				for(int j=0; j<len; j++) {
					if(table[j][i] == 1) {
						isN = true;
					}else if(table[j][i] == 2) {
						if(isN) {
							answer++;
							isN = false;
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}

}
