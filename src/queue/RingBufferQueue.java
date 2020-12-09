package queue;


public class RingBufferQueue {
	private int max;
	private int front;
	private int rear;
	private int num;	//현재 데이터 수
	private int[] que;
	
	//큐가 비어 있음
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException() {}
	}
	
	//큐가 가득 참
	public class OverflowQueueException extends RuntimeException{
		public OverflowQueueException() {}
	}
	
	//생성자
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
		for(int i=0; i<num; i++) {	//num : 데이터 개수
			int idx = (i+front)%max;	//현재 front 위치
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
	
	//큐 안의 모든 데이터 출력
	public void dump() throws EmptyIntQueueException{
		if(num<=0) throw new EmptyIntQueueException();
		else {
			for(int i=0; i<num ;i++) {
				System.out.println(que[(i+front)%max]);
			}
		}
	}
	
	//임의의 데이터 검색
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
		System.out.println("2번째 인덱스 값은 "+ queue.indexOf(2));
		System.out.println("3이 들어있는 인덱스는 "+queue.search(3));
		System.out.println("pop() "+queue.deque());
		System.out.println("pop() "+queue.deque());
		System.out.println("pop() "+queue.deque());
	}

}
