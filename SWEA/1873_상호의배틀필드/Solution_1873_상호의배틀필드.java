package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.)*/

/*U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.*/

public class Solution_1873_상호의배틀필드 {
	
	public static int[] getCurrent(char[][] map, int w, int h) {
		int[] current = new int[3];
		for(int i=0; i<h; i++){
			for(int j=0; j<w; j++) {
				if(map[i][j] == '^') {
					current[0] = i;
					current[1] = j;
					current[2] = 1;
					break;
				}
				if(map[i][j] == 'v') {
					current[0] = i;
					current[1] = j;
					current[2] = 2;
					break;
				}
				if(map[i][j] == '>') {
					current[0] = i;
					current[1] = j;
					current[2] = 3;
					break;
				}
				if(map[i][j] == '<') {
					current[0] = i;
					current[1] = j;
					current[2] = 4;
					break;
				}
			}
		}
		return current;
	}
	
	public static char[][] shoot(char[][] map, int x, int y, int direc) {
		switch(direc) {
		case 1:
			while(x > 0) {
				if(map[x-1][y] == '#')
					break;
				else if(map[x-1][y] == '*') {
					map[x-1][y] = '.';
					break;
				}
				x--;
			}
			break;
		case 2:
			while(x < map.length-1) {
				if(map[x+1][y] == '#')
					break;
				else if(map[x+1][y] == '*') {
					map[x+1][y] = '.';
					break;
				}
				x++;
			}
			break;
		case 3:
			while(y < map[0].length-1) {
				if(map[x][y+1] == '#')
					break;
				else if(map[x][y+1] == '*') {
					map[x][y+1] = '.';
					break;
				}
				y++;
			}
			break;
		case 4:
			while(y > 0) {
				if(map[x][y-1] == '#')
					break;
				else if(map[x][y-1] == '*') {
					map[x][y-1] = '.';
					break;
				}
				y--;
			}
			break;
		}
		return map;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		for(int i=0; i<testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			//int h = sc.nextInt(); //맵 높이
			//int w = sc.nextInt(); //맵 너비
			//sc.nextLine();
			
			char[][] map = new char[h][w]; //맵
			for(int j=0; j<h; j++)
				map[j] = br.readLine().toCharArray();
				//map[j] = sc.nextLine().toCharArray();
			
			//int move = sc.nextInt(); //동작 수
			//sc.nextLine();
			//char[] moves = sc.nextLine().toCharArray(); //동작들 배열
			int move = Integer.parseInt(br.readLine());
			char[] moves = br.readLine().toCharArray();
			
			//현재 전차의 위치
			int[] current = getCurrent(map, w, h);
			int x = current[0];
			int y = current[1];
			int direc = current[2]; //(위 아래 오른쪽 왼족 순서대로 1 2 3 4)
			
			for(int j=0; j<move; j++) {
				//System.out.println(moves[j]);
				switch(moves[j]) {
				case 'U':
					direc = 1;
					map[x][y] = '^';
					if(x > 0 && map[x-1][y] == '.') {
						map[x][y] = '.';
						map[x-1][y] = '^';
						x--;
					}
					break;
				case 'D':
					direc = 2;
					map[x][y] = 'v';
					if(x < h-1 && map[x+1][y] == '.') {
						map[x][y] = '.';
						map[x+1][y] = 'v';
						x++;
					}
					break;
				case 'R':
					direc = 3;
					map[x][y] = '>';
					if(y < w-1 && map[x][y+1] == '.') {
						map[x][y] = '.';
						map[x][y+1] = '>';
						y++;
					}
					break;
				case 'L':
					direc = 4;
					map[x][y] = '<';
					if(y > 0 && map[x][y-1] == '.') {
						map[x][y] = '.';
						map[x][y-1] = '<';
						y--;
					}
					break;
				case 'S':
					map = shoot(map, x, y, direc);
					break;
				} //switch
			} //for move
			
			System.out.print("#" + (i+1) + " ");
			for(int j=0; j<h; j++) {
				for(int k=0; k<w; k++) {
					System.out.print(map[j][k]);
				}
				System.out.println();
			}
		
		} //for testCase
	} //main
}
