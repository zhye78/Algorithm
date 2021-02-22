import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_9663_NQueen {
	
	static int N;
	static int[] arr;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N]; //각 행마다 퀸을 놓은 열 인덱스 저장
		
		dfs(0);
		System.out.println(count);
	}

	public static void dfs(int current) {
		if(current == N) {
			System.out.println(Arrays.toString(arr));
			count++;
			return;
		}
		for(int i=0; i<N; i++) {
			if(check(current, i)) {
				arr[current] = i;
				dfs(current+1);
			}
		}
	}
	
	public static boolean check(int current, int idx) {
		for(int i=0; i<current; i++) {
			if(arr[i] == idx) //같은 열에 있거나
				return false;
			if(Math.abs(i - current) == Math.abs(arr[i] - idx)) //대각선에 있으면
				return false;
		}
		return true;
	}
}
