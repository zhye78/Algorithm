package day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {
	
	static int[] kyuArr; //규영이 카드
	static int[] inArr; //인영이 카드 후보
	static int kyuWin;
	static int kyuLose;
	
	public static void permutation(int current, boolean[] visited, int[] temp) {
		if (current == 9) {
			int kyu = 0;
			int in = 0;
			for(int i=0; i<9; i++) {
				if(kyuArr[i] > temp[i])
					kyu += (kyuArr[i] + temp[i]);
				else if(kyuArr[i] < temp[i])
					in += (kyuArr[i] + temp[i]);
			}
			if(kyu > in)
				kyuWin++;
			else if(kyu < in)
				kyuLose++;
		} else {
			for (int i = 0; i < inArr.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					temp[current] = inArr[i];
					permutation(current + 1, visited, temp);
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			kyuArr = new int[9];
			inArr = new int[9];
			boolean[] check = new boolean[18];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				kyuArr[i] = Integer.parseInt(st.nextToken());
				check[kyuArr[i]-1] = true;
			}
			
			int idx = 0;
			for(int i=0; i<18; i++)
				if(!check[i])
					inArr[idx++] = i+1;
			
			kyuWin = 0;
			kyuLose = 0;
			boolean[] visited = new boolean[18];
			int[] temp = new int[9]; //인영이가 뽑을 카드
			permutation(0, visited, temp);
			
			System.out.println("#" + tc + " " + kyuWin + " " + kyuLose);
		}
	}

}
