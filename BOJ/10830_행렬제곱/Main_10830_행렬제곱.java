package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10830_행렬제곱 {
	static int N;
	static long[][] matrix;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		matrix = new long[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				matrix[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		long[][] answer = multipleMatrix(B);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(answer[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static long[][] multipleMatrix(long B) {
		long[][] temp = new long[N][N];
		
		if(B == 1) { //B가 1이면 matrix % 1000 리턴
			for(int i=0; i<N; i++)
				for(int j=0; j<N; j++)
					temp[i][j] = matrix[i][j] % 1000;
			return temp;
		}
		
		temp = multipleMatrix(B / 2); //B가 2로 더 나누어지면 분할
		long[][] temp2 = new long[N][N]; //temp끼리 곱해서 저장할 배열 변수
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					temp2[i][j] += temp[i][k] * temp[k][j];
				}
				temp2[i][j] %= 1000;
			}
		}
		
		if(B % 2 == 1) {
			//B % 2 가 1이라면 matrix를 한번 더 곱해야 함. 한번 더 곱해서 저장할 배열 변수
			long[][] temp3 = new long[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					for(int k=0; k<N; k++) {
						temp3[i][j] += temp2[i][k] * matrix[k][j];
					}
					temp3[i][j] %= 1000;
				}
			}
			return temp3;
		}else {
			return temp2;
		}
		
	} //multipleMatrix

}
