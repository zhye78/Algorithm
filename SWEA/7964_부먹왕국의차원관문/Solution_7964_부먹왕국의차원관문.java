package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7964_부먹왕국의차원관문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			Queue<String> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++)
				q.offer(st.nextToken());
			
			int cnt = 0;
			int answer = 0;
			for(int i=0; i<N; i++) {
				String now = q.poll();
				if(now.equals("1")) {
					cnt = 0;
					q.offer(now);
					continue;
				}
				else {
					cnt++;
				}
				if(cnt >= D) {
					cnt = 0;
					q.offer("1");
					answer++;
				}else {
					q.offer(now);
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}

}
