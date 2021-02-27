package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1655_가운데를말해요 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> minQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(br.readLine());
			if(i % 2 == 0) //max heap에 삽입
				maxQ.add(now);
			else //min heap에 삽입
				minQ.add(now);
			if(!maxQ.isEmpty() && !minQ.isEmpty() && maxQ.peek() > minQ.peek()) {
				int temp = minQ.poll();
				minQ.add(maxQ.poll());
				maxQ.add(temp);
			}
			sb.append(maxQ.peek()).append("\n");
		}
		
		System.out.println(sb);
	}

}
