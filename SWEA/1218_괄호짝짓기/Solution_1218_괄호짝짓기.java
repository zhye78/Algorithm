package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_1218_괄호짝짓기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Character> list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			int len = Integer.parseInt(br.readLine());
			String s = br.readLine();
			boolean isBreak = false;
			list.clear();
			
			for(int j=0; j<len; j++) {
				char c = s.charAt(j);
				if(c == '(' || c == '{' || c == '<' || c == '[') {
					list.add(c);
				}else {
					if(c ==')' && list.contains('(')) {
						list.remove(list.indexOf('('));
					}
					else if(c =='}' && list.contains('{')) {
						list.remove(list.indexOf('{'));
					}
					else if(c =='>' && list.contains('<')) {
						list.remove(list.indexOf('<'));
					}
					else if(c ==']' && list.contains('[')) {
						list.remove(list.indexOf('['));
					}
					else {
						isBreak = true;
						break;
					}
				}
				//System.out.println(list);
			}
			System.out.print("#" + (i+1) + " ");
			if(isBreak || list.size() != 0)
				System.out.println(0);
			else
				System.out.println(1);
		}
	}

}
