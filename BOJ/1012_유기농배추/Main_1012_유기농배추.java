package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[][] field = new int[h][w];
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				field[y][x] = 1;
			}
			
			boolean[][] visited = new boolean[h][w];
			Stack<int[]> stack = new Stack<>();
			int total = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(field[i][j] == 1 && !visited[i][j]) {
						stack.add(new int[] {i,j});
						visited[i][j] = true;
						while(!stack.isEmpty()) {
							int[] now = stack.pop();
							int x = now[0];
							int y = now[1];
							//사방 체크
							if(x > 0 && !visited[x-1][y] && field[x-1][y] == 1) { //상
								stack.add(new int[] {x-1, y});
								visited[x-1][y] = true;
							}
							if(x < h-1 && !visited[x+1][y] && field[x+1][y] == 1) { //하
								stack.add(new int[] {x+1, y});
								visited[x+1][y] = true;
							}
							if(y > 0 && !visited[x][y-1] && field[x][y-1] == 1) { //좌
								stack.add(new int[] {x, y-1});
								visited[x][y-1] = true;
							}
							if(y < w-1 && !visited[x][y+1] && field[x][y+1] == 1) { //우
								stack.add(new int[] {x, y+1});
								visited[x][y+1] = true;
							}
						}
						total++;
					}
				}
			}
			System.out.println(total);
		}
	}

}
