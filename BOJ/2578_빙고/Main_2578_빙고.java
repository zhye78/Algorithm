package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2578_빙고 {
	
	static int[][] bingo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bingo = new int[5][5];
		
		StringTokenizer st;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++)
				bingo[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				int a = Integer.parseInt(st.nextToken());
				count += check(a);
				if(count >= 3) {
					System.out.println(i*5+j+1);
					System.exit(0);
				}
			}
		}
		
	}
	
	public static int check(int a) {
		int x = -1;
		int y = -1;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(bingo[i][j] == a) {
					bingo[i][j] = 0;
					x = i;
					y = j;
				}
			}
		}
		
		int returnVal = 0;
		
		int cnt = 0;
		for(int i=0; i<5; i++) {
			if(bingo[x][i] != 0)
				break;
			cnt++;
		}
		if(cnt == 5) returnVal++;
		
		cnt = 0;
		for(int i=0; i<5; i++) {
			if(bingo[i][y] != 0)
				break;
			cnt++;
		}
		if(cnt == 5) returnVal++;
		
		cnt = 0;
		if(x == y) {
			for(int i=0; i<5; i++) {
				if(bingo[i][i] != 0)
					break;
				cnt++;
			}
		}
		if(cnt == 5) returnVal++;
		
		cnt = 0;
		if(x + y == 4) {
			for(int i=0; i<5; i++) {
				if(bingo[i][4-i] != 0)
					break;
				cnt++;
			}
		}
		if(cnt == 5) returnVal++;
		
		return returnVal;
	}

}
