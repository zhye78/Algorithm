package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int minVal;
	static int[][] all;
	static boolean[] isCheck;
	
	public static void combi(int r, int current, int start, int[] temp, boolean[] isCheck) {
		if(current == r) {
			int startTeam = 0;
			int linkTeam = 0;
			
			for(int i=0; i<all.length-1; i++) {
				for(int j=i+1; j<all.length; j++) {
					if(isCheck[i] && isCheck[j]) {
						startTeam += all[i][j];
						startTeam += all[j][i];
					}
					else if(!isCheck[i] && !isCheck[j]) {
						linkTeam += all[i][j];
						linkTeam += all[j][i];
					}
				}
			}
			minVal = Math.min(minVal, Math.abs(startTeam - linkTeam));
			return;
		}
		
		for(int i=start; i<all.length; i++) {
			temp[current] = i;
			isCheck[i] = true;
			combi(r, current+1, i+1, temp, isCheck);
			isCheck[i] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[] temp = new int[len/2];
		all = new int[len][len];
		for(int i=0; i<len; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<len; j++) {
				all[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		minVal = Integer.MAX_VALUE;
		isCheck = new boolean[len];
		combi(len/2, 0, 0, temp, isCheck);
		System.out.println(minVal);
	}

}
