package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_10866_덱 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		LinkedList<String> dq = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			switch(s[0]) {
			case "push_back":
				dq.offerLast(s[1]);
				break;
			case "push_front":
				dq.offerFirst(s[1]);
				break;
			case "front":
				if(dq.isEmpty())
					sb.append("-1\n");
				else
					sb.append(dq.peekFirst()).append("\n");
				break;
			case "back":
				if(dq.isEmpty())
					sb.append("-1\n");
				else
					sb.append(dq.peekLast()).append("\n");
				break;
			case "size":
				sb.append(dq.size()).append("\n");
				break;
			case "empty":
				if(dq.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
			case "pop_front":
				if(dq.isEmpty())
					sb.append("-1\n");
				else
					sb.append(dq.pollFirst()).append("\n");
				break;
			case "pop_back":
				if(dq.isEmpty())
					sb.append("-1\n");
				else
					sb.append(dq.pollLast()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

}
