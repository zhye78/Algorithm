package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	
	static int[] soldier;
	static int maxVal;
	
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static int[][] copyMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		soldier = new int[M];
		for(int i=0; i<M; i++)
			soldier[i] = i;
		
		map = new int[N][M];
		copyMap = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] temp = new int[3];
		combination(0, 0, temp);
		System.out.println(maxVal);
	}
	
	public static void combination(int current, int start, int[] temp) {
		if(current == 3) {
			for(int i=0; i<N; i++)
				copyMap[i] = Arrays.copyOf(map[i], M);
			int count = 0;
			int turn = 0;
			Queue<Integer> q = new LinkedList<>();
			
			while(turn < N) {
				System.out.println("turn: " + turn);
				//////하나의 턴//////
				for(int k=0; k<3; k++) {
					//다음 턴으로 넘어갈 때마다 각 궁수들의 행을 한 칸 앞으로!(map 전체(적의 위치)를 한 칸씩 앞으로 땡기는 것보다 간단하기 때문)
					int x = N-turn;
					int y = temp[k];
					
					int min = Integer.MAX_VALUE;
					int minX = -1;
					int minY = -1;
					///각 궁수마다 가장 가까운 적을 찾는다.///
					for(int i=N-1-turn; i>=0; i--) { //행은 맨 아래(궁의 바로 앞)부터 탐색
						for(int j=0; j<M; j++) {
							if(copyMap[i][j] == 1) {
								int d = Math.abs(i-x) + Math.abs(j-y);
								if(d <= D) { //만약 적과 현재 궁수(temp[k]) 거리가 D 이하라면!!!
									if(d < min) { //거리가 min보다 작다면 갱신
										min = d;
										minX = i;
										minY = j;
									}else if(d == min) { //거리가 같을땐 더 왼쪽에 있는 적 위치로 갱신
										if(minY > j) {
											minX = i;
											minY = j;
										}
									}
								}
							} //if - copyMap[i][j] == 1
						} //for - j
					} //for - i
					
					//구한 temp[k]가 죽일 적의 위치를 큐에 삽입 - 죽일 적이 없어서 초기값인 (-1,-1)이라면 제외
					if(minX != -1 && minY != -1) {
						q.offer(minX);
						q.offer(minY);
					}
				} //for - k(궁수 3명 탐색)
				
				while(!q.isEmpty()) {
					int x = q.poll();
					int y = q.poll();
					if(copyMap[x][y] == 1) {
						copyMap[x][y] = 0;
						count++;
					}
				}
				//////하나의 턴 끝//////
				turn++;
			}
			
			if(maxVal < count) maxVal = count;
			return;
		}
		for(int i=start; i<soldier.length; i++) {
			temp[current] = soldier[i];
			combination(current+1, i+1, temp);
		}
	}
}
