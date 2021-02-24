package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {
	
	static int len;
	static int[][] paper;
	static int white;
	static int blue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		len = Integer.parseInt(br.readLine());
		paper = new int[len][len];
		
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<len; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check(len, 0, 0);
		System.out.println(white);
		System.out.println(blue);
	}

	public static void check(int len, int x, int y) {
		if(len == 1) {
			if(paper[x][y] == 0) white++;
			else blue++;
			return;
		}
		
		int first = paper[x][y];
		boolean isChange = false;
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if(paper[x+i][y+j] != first) {
					isChange = true;
					break;
				}
			}
		}
		
		if(isChange) {
			check(len/2, x, y);
			check(len/2, x, y + len/2);
			check(len/2, x + len/2, y);
			check(len/2, x + len/2, y + len/2);
		}else {
			if(first == 0) white ++;
			else blue ++;
		}
	}
}
