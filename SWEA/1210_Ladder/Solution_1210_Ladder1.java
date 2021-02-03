package com.ssafy;

import java.util.Scanner;

public class Solution_1210_Ladder1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] ladder = new int[100][100];
		
		for(int i=0; i<10; i++) {
			int test = sc.nextInt();
			
			for(int j=0; j<100; j++) {
				for(int k=0; k<100; k++) {
					ladder[j][k] = sc.nextInt();
				}
			}
			
			for(int j=0; j<100; j++) {
				if(ladder[0][j] == 0) continue;
				int x = 0;
				int y = j;
				int[][] visited = new int[100][100];
				visited[x][y] = 1;
				
				while(x != 99) {
					if(y < 99 && ladder[x][y+1] == 1 && visited[x][y+1] == 0)
						y++;
					else if(y > 0 && ladder[x][y-1] == 1 && visited[x][y-1] == 0)
						y--;
					else
						x++;
					visited[x][y] = 1;
					
					if(x == 99 && ladder[x][y] == 2) {
						System.out.println("#" + test + " " + j);
						break;
					}
				} //while
			} //for j
		} //for i
		
	}//main

}
