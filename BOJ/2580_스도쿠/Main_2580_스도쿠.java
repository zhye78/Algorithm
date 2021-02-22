import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2580_스도쿠 {

	static int N = 9;
	static int[][] map;
	static boolean[][] fulled;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
	}
	
	public static void dfs(int x, int y) {
		if(y == N) {
			dfs(x+1, 0);
			return;
		}
		
		if(x == N) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		if(map[x][y] == 0) { //현재 스도쿠 위치가 빈칸이라면
			for(int num = 1; num <= N; num++) { //빈 칸에 1~9까지 넣어볼것임
				if(check(x, y, num)) { //가로 세로 같은 9칸에 num이 없으면
					map[x][y] = num;
					dfs(x, y+1);
				}
			}
			map[x][y] = 0;
			return;
		}
		
		dfs(x, y+1);
	}

	public static boolean check(int x, int y, int n) {
		for(int i=0; i<N; i++) {
			if(map[x][i] == n) return false; //가로에 있으면 false
			if(map[i][y] == n) return false; //세로에 있으면 false
		}

		for(int i=(x/3)*3; i<(x/3)*3+3; i++) {
			for(int j=(y/3)*3; j<(y/3)*3+3; j++) {
				if(map[i][j] == n) return false; //같은 칸에 있으면 false
			}
		}
		return true;
	}
}
