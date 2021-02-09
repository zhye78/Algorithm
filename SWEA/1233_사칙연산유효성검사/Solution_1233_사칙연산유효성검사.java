package com.ssafy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_1233_사칙연산유효성검사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		for(int tc=1; tc<=10; tc++) {
			int all = Integer.parseInt(br.readLine());
			char[] nodes = new char[all+1];
			int isPass = 1;
			
			for(int i=1; i<=all; i++) {
				String[] node = br.readLine().split(" ");
				nodes[i] = node[1].charAt(0);
			}
				
			int nodeNum = 1;
			while(nodeNum <= all) {
				boolean isBreak = false;
				for(int idx=nodeNum; idx<nodeNum*2; idx++) { //한 레벨씩 체크
					if(idx > all) break;
					
					if(Character.isDigit(nodes[idx])) { //만약 숫자면
						if(idx * 2 <= all) { //최하위인지 체크 - 최하위 층이 아니라면 유효하지 않음
							isBreak = true;
							break;
						}
					}else { //문자면
						if(idx * 2 > all || idx * 2 + 1 > all) { //최하위인지 체크 - 최하위 층이 맞다면 유효하지 않음
							isBreak = true;
							break;
						}
					}
				}
				if(isBreak) {
					isPass = 0;
					break;
				}
				nodeNum *= 2;
			}
			
			System.out.println("#" + tc + " " + isPass);
		}
	}
}
