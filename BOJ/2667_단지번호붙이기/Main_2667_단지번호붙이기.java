package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main_2667_단지번호붙이기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		for(int i=0; i<N; i++)
			map[i] = br.readLine().toCharArray();
		
		Stack<int[]> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		int total = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == '1' && !visited[i][j]) {
					stack.add(new int[] {i, j});
					visited[i][j] = true;
					int count = 0;
					while(!stack.isEmpty()) {
						int[] now = stack.pop();
						int x = now[0];
						int y = now[1];
						count++;
						//사방 체크
						if(x > 0 && !visited[x-1][y] && map[x-1][y] == '1') { //상
							stack.add(new int[] {x-1, y});
							visited[x-1][y] = true;
						}
						if(x < N-1 && !visited[x+1][y] && map[x+1][y] == '1') { //하
							stack.add(new int[] {x+1, y});
							visited[x+1][y] = true;
						}
						if(y > 0 && !visited[x][y-1] && map[x][y-1] == '1') { //좌
							stack.add(new int[] {x, y-1});
							visited[x][y-1] = true;
						}
						if(y < N-1 && !visited[x][y+1] && map[x][y+1] == '1') { //우
							stack.add(new int[] {x, y+1});
							visited[x][y+1] = true;
						}
					}
					total++;
					list.add(count);
				}
			}
		}
		
		System.out.println(total);
		Collections.sort(list);
		for(int i : list)
			System.out.println(i);
	}

}
