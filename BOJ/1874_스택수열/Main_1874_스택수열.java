package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main_1874_스택수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		List<Character> op = new ArrayList<>();
		int count = 1;
		boolean isBreak = false;
		for(int i=0; i<num; i++) {
			int n = Integer.parseInt(br.readLine());
			while(count <= n) {
				op.add('+');
				stack.push(count++);
			}
			if(n == stack.peek()) {
				op.add('-');
				stack.pop();
			}else {
				isBreak = true;
				break;
			}
		}
		if(isBreak)
			System.out.println("NO");
		else
			for(int i=0; i<op.size(); i++)
				System.out.println(op.get(i));
	}
}
