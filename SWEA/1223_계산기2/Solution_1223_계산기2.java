package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1223_계산기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> numStack = new Stack<>();
		Stack<Character> opStack = new Stack<>();
		
		for(int tc=1; tc<=10; tc++) {
			int len = Integer.parseInt(br.readLine());
			String expression = br.readLine();
			int answer = 0;
			numStack.clear();
			opStack.clear();
			
			for(int i=0; i<len; i++) {
				char c = expression.charAt(i);
				if(i % 2 == 0) {
					numStack.push(Character.getNumericValue(c));
					if(opStack.size() > 0 && opStack.peek() == '*') {
						opStack.pop();
						numStack.push(numStack.pop() * numStack.pop());
					}
				}else {
					opStack.push(c);
				}
			}
			for(int a : numStack)
				answer += a;
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
