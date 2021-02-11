package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			Queue<Integer> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<len; i++)
				q.offer(Integer.parseInt(st.nextToken()));
			
			int count = 0;
			while(true) {
				int out = q.poll();
				boolean isBreak = false;
				
				for(int i : q) {
					if(out < i) {
						q.offer(out);
						if(idx != 0)
							idx--;
						else
							idx = q.size()-1;
						isBreak = true;
						break;
					}
				}
				
				if(!isBreak) {
					count++;
					if(idx == 0) {
						sb.append(count).append("\n");
						break;
					}
					idx--;
				}
			}
		}
		System.out.println(sb);
	}
}
