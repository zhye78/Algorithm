package day0201;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_원재의메모리복구하기_D3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		//BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
		Scanner sc = new Scanner(System.in);
		
		//int T = Integer.parseInt(br.readLine()); //total 테케 수
		int T = sc.nextInt();
		sc.nextLine();
		//ArrayList<String> list = new ArrayList<>();
		//for(int i=0; i<T; i++)
			//list.add(br.readLine());
		
		//System.out.println(list);
		for(int i=0; i<T; i++) {
			System.out.print("#" + (i+1) + " ");
			//bw.write("#");
			//bw.write(i+1);
			//bw.write(" ");
			int count = 0;
			char last = '0';
			//String s = br.readLine();
			String s = sc.nextLine();
			for(int j=0; j<s.length(); j++) {
				if(s.charAt(j) != last) {
					count++;
					if(last == '0') last = '1';
					else last = '0';
				}
			}
			System.out.println(count);
			//bw.write(count);
		}
		
		//br.close();
		//bw.close();
	}
}
