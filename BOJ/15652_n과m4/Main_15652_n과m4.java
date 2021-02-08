package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652_n과m4 {
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void overlapCombi(int r, int current, int start, int[] temp) {
		if(r == current) {
			for(int i=0; i<r; i++)
				sb.append(temp[i]).append(" ");
			sb.append("\n");
		}else {
			for(int i=start; i<numbers.length; i++) {
				temp[current] = numbers[i];
				overlapCombi(r, current+1, i, temp);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[] temp = new int[r];
		numbers = new int[num];
		for(int i=0; i<num; i++)
			numbers[i] = i+1;
		
		overlapCombi(r, 0, 0, temp);
		System.out.println(sb);
	}

}
