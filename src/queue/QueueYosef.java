package queue;
//원형 큐 문제~

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
			System.out.println("Queue가 가득참!");
			return;
		}
		queue[(++rear)%size] = num;
	}
	public Object deleteQ(){
		if(isEmpty()) {
			System.out.println("Queue에 아무 값도 없음");
			return -1;
		}
		return queue[(++front)%size];
	}
	
	//사용자 지정 함수
	//큐 내용 print
	public void printQ() {
		for(int i=0; i<size; i++) System.out.println(queue[i]+" ");
	}
	
	//특정한 인덱스 값 있는지 확인
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
	
	//특정한 인덱스 값 꺼내기
	public Object deleteIndexQ(int num) {
		if(EmptyCheck()) {
			return null;
		}
		int now_index = (front+1)%size; //현재 가장 앞쪽의 value가 있는 index
		
		for(int i=1; i<=num; i++) { //num 횟수만큼 반복
			now_index = (++front)%size;
			if(isEmptyIndex(now_index)) i--;
		}
		
		Object returnQ = queue[now_index];
		queue[now_index] = null;	//큐 비워주기
		
		return returnQ;
	}
}

public class QueueYosef {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleQueue<String> queue;
		
		Scanner scn = new Scanner(System.in);
		int size = scn.nextInt();	//원형 큐 크기
		queue =  new CircleQueue<>(++size);	//front 크기를 위해 size+1
		int order = scn.nextInt();
		
		for(int i=1; i<size; i++) {
			queue.addQ(i); 	//큐에 값 넣어주기
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
