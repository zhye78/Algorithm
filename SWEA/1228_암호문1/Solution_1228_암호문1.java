package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			List<String> list = new ArrayList<>(); //암호문 저장할 배열
			int len = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<len; i++)
				list.add(st.nextToken());
			
			int commands = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int cnt = 0;
			while(cnt != commands) {
				cnt++;
				int idx = -1;
				int num = -1;
				if(st.nextToken().equals("I")) {
					idx = Integer.parseInt(st.nextToken());
					num = Integer.parseInt(st.nextToken());
				}
				for(int j=0; j<num; j++) {
					list.add(idx++, st.nextToken());
				}
			}
			
			System.out.print("#" + tc + " ");
			for(int i=0; i<10; i++)
				System.out.print(list.get(i) + " ");
			System.out.println();
		}
	}
}
