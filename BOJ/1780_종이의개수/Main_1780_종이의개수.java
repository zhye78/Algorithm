package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_종이의개수 {
	
	static int len;
	static int[][] paper;
	static int minus;
	static int zero;
	static int plus;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		len = Integer.parseInt(br.readLine());
		paper = new int[len][len];
		
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<len; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check(len, 0, 0);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}
	
	public static void check(int len, int x, int y) {
		if(len == 1) {
			if(paper[x][y] == -1) minus++;
			else if(paper[x][y] == 0) zero++;
			else plus++;
			return;
		}
		
		boolean isChange = false;
		int first = paper[x][y];
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if(paper[x+i][y+j] != first) {
					isChange = true;
					break;
				}
			}
		}
		
		int nextLen = len/3;
		if(isChange) {
			check(nextLen, x, y);
			check(nextLen, x, y + nextLen);
			check(nextLen, x, y + nextLen * 2);
			check(nextLen, x + nextLen, y);
			check(nextLen, x + nextLen, y + nextLen);
			check(nextLen, x + nextLen, y + nextLen * 2);
			check(nextLen, x + nextLen * 2, y);
			check(nextLen, x + nextLen * 2, y + nextLen);
			check(nextLen, x + nextLen * 2, y + nextLen * 2);
		}else {
			if(first == -1) minus++;
			else if(first == 0) zero++;
			else plus++;
		}
	}

}
