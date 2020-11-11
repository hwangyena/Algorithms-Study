package queue;
//���� ť ����~

import java.util.Scanner;

class CircleQueue<T> {
	int front;
	int rear;
	int size;
	Object[] queue;
	
	CircleQueue(int size) {
		front = 0;
		rear = 0;
		this.size = size;
		queue = new Object[size];
	}
	
	public boolean isEmpty() {
		if(front==rear) return true;
		else return false;
	}
	public boolean isFull() {
		if((rear+1)%size == front) return true;
		else return false;
	}
	public void addQ(Object num) {
		if(isFull()) {
			System.out.println("Queue�� ������!");
			return;
		}
		queue[(++rear)%size] = num;
	}
	public Object deleteQ(){
		if(isEmpty()) {
			System.out.println("Queue�� �ƹ� ���� ����");
			return -1;
		}
		return queue[(++front)%size];
	}
	
	//����� ���� �Լ�
	//ť ���� print
	public void printQ() {
		for(int i=0; i<size; i++) System.out.println(queue[i]+" ");
	}
	
	//Ư���� �ε��� �� �ִ��� Ȯ��
	public boolean isEmptyIndex(int index) {
		if(queue[index] == null) return true;
		else return false;
	}
	
	public boolean EmptyCheck() {
		for(int i=0; i<size; i++) {
			if(queue[i] != null) return false;
		}
		return true;
	}
	
	//Ư���� �ε��� �� ������
	public Object deleteIndexQ(int num) {
		if(EmptyCheck()) {
			return null;
		}
		int now_index = (front+1)%size; //���� ���� ������ value�� �ִ� index
		
		for(int i=1; i<=num; i++) { //num Ƚ����ŭ �ݺ�
			now_index = (++front)%size;
			if(isEmptyIndex(now_index)) i--;
		}
		
		Object returnQ = queue[now_index];
		queue[now_index] = null;	//ť ����ֱ�
		
		return returnQ;
	}
}

public class QueueYosef {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleQueue<String> queue;
		
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();	//���� ť ũ��
		queue =  new CircleQueue<>(++size);	//front ũ�⸦ ���� size+1
		int order = scn.nextInt();
		
		for(int i=1; i<size; i++) {
			queue.addQ(i); 	//ť�� �� �־��ֱ�
		}
		
		Object answer = new Object();
		
		System.out.print("<");
		for(int i=1; i<size; i++) {
			answer = queue.deleteIndexQ(order);
			if(i == size-1) {
				System.out.print(answer);
				break;
			}System.out.print(answer+", ");
		}System.out.println(">");
		
	}

}
