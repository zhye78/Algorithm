package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17418_단어뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String answer = "";
		String temp = "";
		boolean isTag = false;
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '<') {
				answer += new StringBuffer(temp).reverse().toString();
				temp = "" + c;
				isTag = true;
			}
			else if(c == '>') {
				answer += temp + c;
				temp = "";
				isTag = false;
			}
			else if(isTag) {
				temp += c;
			}
			else if(c == ' ') {
				answer += new StringBuffer(temp).reverse().toString() + " ";
				temp = "";
			}
			else {
				temp += c;
			}
		}
		if(isTag) answer += temp;
		else answer += new StringBuffer(temp).reverse().toString();;
		
		System.out.println(answer);
	}

}
