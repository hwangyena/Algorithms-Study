package queue;


public class RingBufferQueue {
	private int max;
	private int front;
	private int rear;
	private int num;	//���� ������ ��
	private int[] que;
	
	//ť�� ��� ����
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException() {}
	}
	
	//ť�� ���� ��
	public class OverflowQueueException extends RuntimeException{
		public OverflowQueueException() {}
	}
	
	//������
	public RingBufferQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max];
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public void enque(int x) throws OverflowQueueException{
		if(num >= max) 
			throw new OverflowQueueException();
		que[rear++] = x;
		num++;
		if(rear == max) rear=0;
	}

	public int deque() throws EmptyIntQueueException{
		if(num == 0) throw new EmptyIntQueueException();
		int x = que[front++];
		num--;
		if(front==max) front=0;
		return x;
	}
	
	public int peek() throws EmptyIntQueueException{
		if(num <= 0) throw new EmptyIntQueueException();
		return que[front];
	}
	
	public int indexOf(int x) {
		for(int i=0; i<num; i++) {	//num : ������ ����
			int idx = (i+front)%max;	//���� front ��ġ
			if(idx == x) return idx;
		}return -1;
	}
	
	public void clear() {
		num = front = rear = 0;
	}
	
	public int capacity() {
		return max;
	}
	
	public int size() {
		return num;
	}
	
	public boolean isEmpty() {
		if(num<=0) return true;
		else return false;
	}
	public boolean isFull() {
		return (num>=max);
	}
	
	//ť ���� ��� ������ ���
	public void dump() throws EmptyIntQueueException{
		if(num<=0) throw new EmptyIntQueueException();
		else {
			for(int i=0; i<num ;i++) {
				System.out.println(que[(i+front)%max]);
			}
		}
	}
	
	//������ ������ �˻�
	public int search(int x){
		if(num <= 0) return 0;
		else {
			for(int i=0; i<num; i++) {
				if(que[(i+front)%max] == x) {
					return i+front+1;
				}
			}
			return 0;
		}
	}
	public static void main(String[] args) {
		RingBufferQueue queue = new RingBufferQueue(64);
		
		queue.enque(1);
		queue.enque(2);
		queue.enque(3);
		queue.dump();
		System.out.println("2��° �ε��� ���� "+ queue.indexOf(2));
		System.out.println("3�� ����ִ� �ε����� "+queue.search(3));
		System.out.println("pop() "+queue.deque());
		System.out.println("pop() "+queue.deque());
		System.out.println("pop() "+queue.deque());
	}

}
