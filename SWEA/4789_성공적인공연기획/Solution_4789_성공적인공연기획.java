package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_4789_성공적인공연기획 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			int now = 0;
			int cnt = 0;
			for(int i=0; i<s.length(); i++) {
				int c = Character.getNumericValue(s.charAt(i));
				if(c > 0 && i > now) {
					cnt += (i-now);
					now += (i-now);
				}
				now += c;
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}

}
