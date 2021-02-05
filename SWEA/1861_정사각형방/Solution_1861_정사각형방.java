package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=testCase; tc++) {
			int len = Integer.parseInt(br.readLine());
			int[][] room = new int[len][len];
			for(int i=0; i<len; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<len; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int maxRoomNum = 1000001; //최대 이동 가능한 출발 방번호
			int maxRoomCnt = 0; //최대 이동 가능한 방 수
			for(int i=0; i<len; i++) {
				for(int j=0; j<len; j++) {
					int x = i;
					int y = j;
					int cnt = 1;
					
					while(true) {
						if(x > 0 && room[x-1][y] == room[x][y]+1) { //상
							x--;
							cnt++;
						}
						else if(x < len-1 && room[x+1][y] == room[x][y]+1) { //하
							x++;
							cnt++;
						}
						else if(y > 0 && room[x][y-1] == room[x][y]+1) { //좌
							y--;
							cnt++;
						}
						else if(y < len-1 && room[x][y+1] == room[x][y]+1) { //우
							y++;
							cnt++;
						}
						else //상하좌우에 더이상 1 큰 번호가 없으면 나가기
							break;
					}
					
					//System.out.println("cnt: " + cnt);
					if(maxRoomCnt < cnt) {
						maxRoomCnt = cnt;
						maxRoomNum = room[i][j];
					}else if(maxRoomCnt == cnt) {
						if(maxRoomNum > room[i][j])
							maxRoomNum = room[i][j];
					}
				}
			}
			
			System.out.println("#" + tc + " " + maxRoomNum + " " + maxRoomCnt);
		}
	}

}
