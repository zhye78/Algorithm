package day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {
	
	static int[][] materials;
	static boolean[] visited;
	static int minVal;
	
	public static void makeSet(int current) {
		if (current == materials.length) {
			int sour = 1;
			int bitter = 0;
			int cnt = 0;
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					cnt++;
					sour *= materials[i][0];
					bitter += materials[i][1];
				}
			}
			if(cnt == 0) return; //재료를 적어도 하나는 써야 하므로, 공집합이면 리턴
			if(minVal > Math.abs(sour - bitter))
				minVal = Math.abs(sour - bitter);
			return;
		}
		visited[current] = true;
		makeSet(current + 1);
		visited[current] = false;
		makeSet(current + 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		materials = new int[n][2];
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			materials[i][0] = Integer.parseInt(st.nextToken());
			materials[i][1] = Integer.parseInt(st.nextToken());
		}
		
		minVal = Integer.MAX_VALUE;
		makeSet(0);
		System.out.println(minVal);
	}

}
