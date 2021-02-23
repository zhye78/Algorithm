package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2851_슈퍼마리오 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		int sum = 0;
		for(int i=0; i<10; i++) {
			int n = Integer.parseInt(br.readLine());
			sum += n;
			if(sum >= 100) {
				if(Math.abs(sum - 100) <= Math.abs(sum - n - 100)) {
					System.out.println(sum);
					System.exit(0);
				}else {
					System.out.println(sum - n);
					System.exit(0);
				}
			}
		}
		System.out.println(sum);
	}

}
