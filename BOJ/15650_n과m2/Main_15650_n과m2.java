package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_n과m2 {
	static int[] numbers;
	
	public static void combination(int r, int current, int[] temp, int start) {
		if(r == current) {
			for(int i=0; i<r; i++)
				System.out.print(temp[i] + " ");
			System.out.println();
		} else {
			for(int i=start; i<numbers.length; i++) {
				temp[current] = numbers[i];
				combination(r, current+1, temp, i+1);
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
		
		combination(r, 0, temp, 0);
	}

}
