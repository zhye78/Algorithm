package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6485_삼성시의버스노선 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine()); //버스 노선 개수
			int[][] bus = new int[N][2]; //버스 노선
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				bus[i][0] = Integer.parseInt(st.nextToken());
				bus[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int P = Integer.parseInt(br.readLine()); //버정 개수
			int[] busStops = new int[P];
			for(int i=0; i<P; i++)
				busStops[i] = Integer.parseInt(br.readLine());
			
			int[] answer = new int[P];
			for(int i=0; i<N; i++) {
				for(int j=0; j<P; j++) {
					if(bus[i][0] <= busStops[j] && busStops[j] <= bus[i][1])
						answer[j]++;
				}
			}
			
			System.out.print("#" + tc + " ");
			for(int i=0; i<P; i++)
				System.out.print(answer[i] + " ");
			System.out.println();
		}
	}

}
