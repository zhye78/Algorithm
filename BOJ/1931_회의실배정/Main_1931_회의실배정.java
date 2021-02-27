package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] meeting = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meeting, new Comparator<int[]>() { //종료시간으로 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] - o2[1] == 0)
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		
		int cnt = 0;
		int last = -1;
		for(int i=0; i<N; i++) {
			if(meeting[i][0] >= last) {
				cnt++;
				last = meeting[i][1];
			}
		}
		
		System.out.println(cnt);
	}

}
