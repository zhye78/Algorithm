package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208_Flatten {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = 10; //전체 테스트케이스의 수
		
		for(int i=0; i<total; i++) {
			int dump = sc.nextInt(); //덤프 수
			int[] boxes = new int[100];
			for(int j=0; j<100; j++)
				boxes[j] = sc.nextInt();
			//System.out.println(boxes);
			
			for(int j=0; j<dump; j++) {
				Arrays.sort(boxes);
				if(boxes[99] - boxes[0] <= 1) //주어진 덤프 횟수 이내에 평탄화가 완료되면 break
					break;
				boxes[0]++;
				boxes[99]--;
			}
			Arrays.sort(boxes);
			System.out.println("#" + (i+1) + " " + (boxes[99] - boxes[0]));
		}
	}

}
