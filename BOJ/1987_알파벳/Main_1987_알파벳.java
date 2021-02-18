package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	
	static int R;
	static int C;
	static String[][] map;
	static int maxVal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new String[R][C];
		for(int i=0; i<R; i++)
			map[i] = br.readLine().split("");
		
		String temp = map[0][0];
		check(0, 0, temp, 1);
		System.out.println(maxVal);
	}

	private static void check(int x, int y, String temp, int cnt) {
		if(x > 0 && !temp.contains(map[x-1][y])) //상
			check(x-1, y, temp + map[x-1][y], cnt+1);
		if(x < R-1 && !temp.contains(map[x+1][y])) //하
			check(x+1, y, temp + map[x+1][y], cnt+1);
		if(y > 0 && !temp.contains(map[x][y-1])) //좌
			check(x, y-1, temp + map[x][y-1], cnt+1);
		if(y < C-1 && !temp.contains(map[x][y+1])) //우
			check(x, y+1, temp + map[x][y+1], cnt+1);
		else {
			if(maxVal < cnt)
				maxVal = cnt;
		}
	}

}
