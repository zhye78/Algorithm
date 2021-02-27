package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N+1];
		
		int len = Integer.parseInt(br.readLine());
		int[][] networks = new int[len][2];
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			networks[i][0] = Integer.parseInt(st.nextToken());
			networks[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1); //1번 컴퓨터가 걸리면서 시작
		int count = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			visited[now] = true;
			for(int[] network : networks) {
				if(network[0] == now && !visited[network[1]]) {
					q.offer(network[1]);
					visited[network[1]] = true;
					count++;
				}
				else if(network[1] == now && !visited[network[0]]) {
					q.offer(network[0]);
					visited[network[0]] = true;
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
