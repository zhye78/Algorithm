package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_n과m1 {
	static int[] numbers;
	
	public static void permutation(int r, int current, int[] temp, boolean[] visited) {
		if(current == r) {
			for(int i=0; i<r; i++)
				System.out.print(temp[i] + " ");
			System.out.println();
		}
		else {
			for(int i=0; i<numbers.length; i++) {
				if(!visited[i]) {
					visited[i] = true;
					temp[current] = numbers[i];
					permutation(r, current+1, temp, visited);
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[] temp = new int[r];
		boolean[] visited = new boolean[num];
		numbers = new int[num];
		for(int i=0; i<num; i++)
			numbers[i] = i+1;
		
		permutation(r, 0, temp, visited);
	}

}
