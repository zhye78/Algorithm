package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		List<Character> ops = new ArrayList<>();
		List<Integer> nums = new ArrayList<>();
		
		String num = "";
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '+' || c == '-') {
				nums.add(Integer.parseInt(num));
				num = "";
				ops.add(c);
			}else {
				num += Character.toString(c);
			}
		}
		nums.add(Integer.parseInt(num));
		
		int idx = 0;
		while(idx < ops.size()) {
			if(ops.get(idx) == '+') {
				int a = nums.get(idx);
				int b = nums.get(idx+1);
				ops.remove(idx);
				nums.remove(idx);
				nums.remove(idx);
				nums.add(idx, a+b);
			}
			else idx++;
		}
		
		int answer = nums.get(0);
		for(int i=1; i<nums.size(); i++)
			answer -= nums.get(i);
		
		System.out.println(answer);
	}

}
