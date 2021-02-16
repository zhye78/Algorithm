package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13305_주유소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] roads = new long[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++)
			roads[i] = Long.parseLong(st.nextToken());
		
		long[] cities = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			cities[i] = Long.parseLong(st.nextToken());
		
		long min = Long.MAX_VALUE;
		long sum = 0;
		for(int i=0; i<N-1; i++) {
			if(min > cities[i])
				min = cities[i];
			sum += roads[i] * min;
		}
		System.out.println(sum);
	}
}
