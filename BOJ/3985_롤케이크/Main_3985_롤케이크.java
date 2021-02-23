package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3985_롤케이크 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[] cake = new int[len + 1];
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		int expect = 0;
		int maxIdx = 0;
		int maxVal = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr[i][0] = start;
			arr[i][1] = end;
			if(arr[expect][1] - arr[expect][0] < end - start)
				expect = i;
			
			int count = 0;
			for(int j=0; j<end - start + 1; j++) {
				if(cake[start + j] == 0) {
					cake[start + j] = i+1;
					count++;
				}
			}
			if(count > maxVal) {
				maxVal = count;
				maxIdx = i;
			}
		}
		
		System.out.println(expect+1);
		System.out.println(maxIdx+1);
	}

}
