package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4698_테네스의특별한소수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			if(B > 1) {
				if(A == 1) A++;
				boolean[] isPass = new boolean[B+1];
				
				for(int i=2; i*i<B+1; i++)
					for(int j=i*i; j<B+1; j+=i)
						isPass[j] = true;
				
				//isPass에서 false인 인덱스들이 소수
				for(int i=A; i<B+1; i++)
					if(!isPass[i])
						if(Integer.toString(i).contains(D+""))
							cnt++;
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}

}
