package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_쿼드트리 {

	static int N;
	static char[][] video;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		video = new char[N][N];
		for (int i = 0; i < N; i++)
			video[i] = br.readLine().toCharArray();
		
		sb = new StringBuilder();
		quadTree(N, 0, 0);
		System.out.println(sb);
	}

	private static void quadTree(int size, int x, int y) { //size와 체크할 시작 인덱스들
		if (size == 1) {
			sb.append(video[x][y]);
			return;
		}
		
		boolean isNon = false;
		char first = video[x][y];
		flag: for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(first != video[i][j]) {
					isNon = true; //하나라도 숫자가 다르다면
					break flag; //2중 for문 한번에 나가기
				}
			}
		}
		
		if(isNon) {
			sb.append("(");
			quadTree(size/2, x, y); //1사분면 체크
			quadTree(size/2, x, y + size/2); //2사분면
			quadTree(size/2, x + size/2, y); //3사분면
			quadTree(size/2, x + size/2, y + size/2); //4사분면
			sb.append(")");
		}
		else
			sb.append(first);
	}
}
