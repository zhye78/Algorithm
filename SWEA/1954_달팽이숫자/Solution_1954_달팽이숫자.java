package com.ssafy;

import java.util.Scanner;

public class Solution_1954_달팽이숫자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			int snail = sc.nextInt(); //달팽이의 크기
			int[][] snailArr = new int[snail][snail]; //달팽이 숫자 배열
			
			int count = 1;
			int x = 0;
			int y = -1;
			int direc = 1; //오른쪽과 아래쪽 방향일 땐 1, 왼쪽과 위쪽 방향일 땐 -1
			int n = snail;
			
			while(n != 0) {
				for(int j=0; j<n; j++) { //오른쪽, 왼쪽
					y += direc;
					snailArr[x][y] = count++;
				}
				n--;
				for(int j=0; j<n; j++) { //아래쪽, 위쪽
					x += direc;
					snailArr[x][y] = count++;
				}
				direc *= -1; //방향 바꾸기 : 오른쪽->왼쪽, 아래쪽->위쪽
			}
			
			System.out.println("#" + (i+1));
			for(int j=0; j<snail; j++) {
				for(int k=0; k<snail; k++)
					System.out.print(snailArr[j][k] + " ");
				System.out.println();
			}
		}
	}

}
