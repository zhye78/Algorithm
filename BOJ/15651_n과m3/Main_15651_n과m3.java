package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15651_n과m3 {
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void overlapPermu(int r, int current, int[] temp) {
		if(r == current) {
			for(int i=0; i<r; i++)
				sb.append(temp[i]).append(" ");
			sb.append("\n");
		}else {
			for(int i=0; i<numbers.length; i++) {
				temp[current] = numbers[i];
				overlapPermu(r, current+1, temp);
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
		
		overlapPermu(r, 0, temp);
		System.out.println(sb);
	}
}
