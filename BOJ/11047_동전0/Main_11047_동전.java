package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11047_동전 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] kinds = new int[N];
		for(int i=0; i<N; i++)
			kinds[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(kinds);
		int cnt = 0;
		for(int i=N-1; i>=0; i--) {
			if(kinds[i] <= K) {
				cnt += K / kinds[i];
				K = K % kinds[i];
			}
			if(K == 0)
				break;
		}
		
		System.out.println(cnt);
	}

}
