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
				for(int j=0; j<ps.length; j++) { //���ڿ� �ϳ���
					if(ps[j].equals("(")) {
						stack.push(1);
					}
					if(ps[j].equals(")")) {
						if(stack.pop() == -1)	{	//���ÿ� ���� ������ no
							bf.write("NO\n");
							break;
						}	
					}
					if(j == ps.length-1) {
						//���ڿ� ������ �� ������ ��
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
