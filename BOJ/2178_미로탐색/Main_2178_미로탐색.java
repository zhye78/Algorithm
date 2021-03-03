package month03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
	
	static int[][] map;
	static int n;
	static int m;
	//static int minVal;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		visited = new boolean[n][m];
		visited[0][0] = true;
		//minVal = Integer.MAX_VALUE;
		bfs(0, 0);
		//dfs(0, 0, 1);
		System.out.println(map[n-1][m-1]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				//다음 좌표가 범위를 넘어갈때 건너뛰기
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
                    continue;
                //이미 방문했던 점이거나 이동 불가 칸이라면 건너뛰기
                if (visited[nextX][nextY] || map[nextX][nextY] == 0)
                    continue;
                //이외에는 방문 가능하므로 큐에 삽입, map값 변경, 방문체크
                q.add(new int[] {nextX, nextY});
                map[nextX][nextY] = map[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
			}
		}
	}
	
	/*public static void dfs(int x, int y, int count) {
		if(x == n-1 && y == m-1) {
			minVal = Math.min(minVal, count);
			return;
		}
		
		if(count > minVal) return; //가지치기 - 이미 count가 minVal보다 커졌다면 return;
		
		if(x > 0 && !visited[x-1][y] && map[x-1][y] == '1') { //상
			visited[x-1][y] = true;
			dfs(x-1, y, count + 1);
			visited[x-1][y] = false;
		}
		if(x < n-1 && !visited[x+1][y] && map[x+1][y] == '1') { //하
			visited[x+1][y] = true;
			dfs(x+1, y, count + 1);
			visited[x+1][y] = false;
		}
		if(y > 0 && !visited[x][y-1] && map[x][y-1] == '1') { //좌
			visited[x][y-1] = true;
			dfs(x, y-1, count + 1);
			visited[x][y-1] = false;
		}
		if(y < m-1 && !visited[x][y+1] && map[x][y+1] == '1') { //우
			visited[x][y+1] = true;
			dfs(x, y+1, count + 1);
			visited[x][y+1] = false;
		}
	}*/
}
