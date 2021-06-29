package stack;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class StackPS extends StackBasic{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		BufferedWriter bf = null;
		
		try {
			bf= new BufferedWriter(new OutputStreamWriter(System.out));
			for(int i=0; i<num; i++) {	
				Stack<Integer> stack = new Stack<>(num);
				
				String[] ps = scn.next().split("");
				for(int j=0; j<ps.length; j++) { //문자열 하나씩
					if(ps[j].equals("(")) {
						stack.push(1);
					}
					if(ps[j].equals(")")) {
						if(stack.pop() == -1)	{	//스택에 값이 없으면 no
							bf.write("NO\n");
							break;
						}	
					}
					if(j == ps.length-1) {
						//문자열 끝까지 다 돌았을 때
						if(stack.empty() == 1) {
							bf.write("YES\n");
						}else bf.write("NO\n");
					}
				}
				
			}
			
			bf.flush();
			bf.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
