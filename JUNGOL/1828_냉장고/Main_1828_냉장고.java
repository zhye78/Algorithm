package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1828_냉장고 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] substances = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			substances[i][0] = Integer.parseInt(st.nextToken());
			substances[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(substances, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});
		
		int count = 1;
		int start = substances[0][0];
		int end = substances[0][1];
		for(int[] substance : substances) {
			if(start <= substance[0] && substance[0] <= end) {
				if(end <= substance[1] && substance[1] <= end) {
					start = substance[0];
					end = substance[1];
				}else
					continue;
			}else {
				start = substance[0];
				end = substance[1];
				count++;
			}
		}
		System.out.println(count);
	}

}
