package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				else return o1[0] - o2[0];
			}
		});
		
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(br.readLine());
			if(now != 0) {
				if(now > 0) q.add(new int[] {now, 1});
				else q.add(new int[] {now*-1, -1});
			}
			else {
				if(q.isEmpty())
					System.out.println(0);
				else {
					int[] arr = q.poll();
					if(arr[1] == 1)
						System.out.println(arr[0]);
					else
						System.out.println(arr[0]*-1);
				}
			}
		}

	}

}
