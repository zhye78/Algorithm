package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1255_암호생성기{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<10; i++) {
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			q.clear();
			
			for(int j=0; j<8; j++)
				q.offer(Integer.parseInt(st.nextToken()));

			int del = 1;
			while(true) {
				int a = q.poll() - del;
				if(a <= 0) {
					q.offer(0);
					break;
				}else {
					q.offer(a);
				}
				if(del < 5)
					del++;
				else
					del = 1;
			}
			
			sb.append("#" + num + " ");
			while(q.size() != 0)
				sb.append(q.poll() + " ");
			System.out.println(sb);
		}
	}

}
