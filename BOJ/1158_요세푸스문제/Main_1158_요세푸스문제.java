package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++)
			q.offer(i);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int cnt = 0;
		while(!q.isEmpty()) {
			cnt++;
			if(cnt % k == 0)
				sb.append(q.poll() + ", ");
			else
				q.offer(q.poll());
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}
}
