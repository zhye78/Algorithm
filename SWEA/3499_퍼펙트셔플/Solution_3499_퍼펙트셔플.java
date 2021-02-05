package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=testCase; tc++) {
			int len = Integer.parseInt(br.readLine());
			String[] cards = br.readLine().split(" ");
			int i=0;
			System.out.print("#" + tc + " ");
			
			if(len % 2 == 0) {
				while(i < len/2) {
					System.out.print(cards[i] + " ");
					if(i + len/2 < len)
						System.out.print(cards[i + len/2] + " ");
					i++;
				}
			}else {
				while(i < len/2 + 1) {
					System.out.print(cards[i] + " ");
					if(i + len/2 + 1 < len)
						System.out.print(cards[i + len/2 + 1] + " ");
					i++;
				}
			}
			System.out.println();
		}
	}

}
