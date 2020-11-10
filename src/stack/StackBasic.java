package stack;

import java.io.*;
import java.util.Scanner;

//���� ���� ����
class Stack<T>{
	int[] stack;
	int top;
	int size;
	
	//������
	public Stack(int size){
		top=-1;
		this.size = size;
		stack = new int[size];
	}

	void push(int num) {
		stack[++top] = num;
	}
	
	int pop() {
		if(top<0) return -1;
		else {
			int popnum = stack[top];
			stack[top--] = 0;
			return popnum;
		}
	}
	
	int size() {return top+1;}
	
	int empty() {
		if(top<0) return 1;
		else return 0;
	}
	
	int top() {
		if(top<0) return -1;
		else return stack[top];
	}
}

public class StackBasic {
	public static void main(String[] args) {
		BufferedWriter bw=null;
		
		try {
			Scanner scn = new Scanner(System.in);
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = scn.nextInt();		//��� ����
			String command;
			
			Stack<Integer> stack = new Stack<Integer>(num);	//���� ��ü����(����ũ�� 20)
			
			for(int i=0; i<num; i++) {
				command = scn.next();
				////System.out.println("��ɾ� : "+command);
				//push 
				if(command.equals("push")) {
					int numPush = scn.nextInt();
					stack.push(numPush);
				}
					
				//pop
				if(command.equals("pop")) bw.write(stack.pop()+"\n");
				
				//size
				if(command.equals("size")) bw.write(stack.size()+"\n");
				
				//empty
				if(command.equals("empty")) bw.write(stack.empty()+"\n");
				
				//top
				if(command.equals("top")) {
					bw.write(stack.top()+"\n");
				}
			}

			bw.flush();
			bw.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
