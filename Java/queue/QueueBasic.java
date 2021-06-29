package queue;

import java.io.*;
import java.util.*;

class Queue_made<T>{
	int front;	//큐의 가장 앞에 있는 정수
	int back;
	int size;
	int[] queue;
	
	Queue_made(int size){
		front = -1;
		back = -1;
		this.size = size;
		queue = new int[size];
	}
	
	void push(int x) {
		queue[++back] = x;	
	}
	
	int pop() {
		if(front == back) return -1;	//큐에 값이 없음
		else	return queue[++front];
	}
	
	int empty() {
		if(front == back) return 1;
		else return 0;
	}
	
	int front() {
		if(front == back) return -1;
		else return queue[front+1];
	}
	
	int back() {
		if(front == back) return -1;
		else return queue[back];
	}
	
	int size() {
		return back-front;
	}
	
	void printQueue() {
		if(front == back) return ;
		else {
			for(int i=0; i<=back; i++) System.out.println("queue["+i+"] = "+queue[i]);
		}
	}
}

public class QueueBasic {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int num = scn.nextInt();
			Queue_made<Integer> queue = new Queue_made<Integer>(num);
			
			for(int i=0; i<num; i++) {
				String command = scn.next();
				
				if(command.equals("push")) {
					int numPush = scn.nextInt();
					queue.push(numPush);
				}
				
				if(command.equals("pop")) {
					bw.write(queue.pop()+"\n");
				}
				
				if(command.equals("size")) {
					bw.write(queue.size()+"\n");
				}
				
				if(command.equals("empty")) {
					bw.write(queue.empty()+"\n");
				}
				
				if(command.equals("front")) {
					bw.write(queue.front()+"\n");
				}
				
				if(command.equals("back")) {
					bw.write(queue.back()+"\n");
				}
				
				if(command.equals("printQ")) {
					queue.printQueue();
				}
				
			}
			
			bw.flush();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
