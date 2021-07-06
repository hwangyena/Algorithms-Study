package tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {
	private final Comparator<? super E> comparator;
	private static final int DEFAULT_CAPACITY = 10;	//최소 크기
	
	private int size;	//요소 개수
	private Object[] array;	//요소를 담을 배열
	
	//생성자1 (초기 공간 할당 X)
	public Heap() {
		this(null);
	}
	
	public Heap(Comparator<? super E> comparator) {
		this.array = new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.comparator = comparator;
	}
	

	//생성자2 (초기 공간 할당 O)
	public Heap(int capacity) {
		this(capacity, null);
	}
	public Heap(int capacity, Comparator<? super E> comparator) {
		this.array = new Object[capacity];
		this.size = 0;
		this.comparator = comparator;
	}
	
	//받은 인덱스의 부모 노드 인덱스 반환
	private int getParent(int index) {
		return index/2;
	}
	
	//왼쪽 자식 노드 인덱스 반환
	private int getLeftChild(int index) {
		return index*2;
	}
	
	//오른쪽 자식 노드 인덱스 반환
	private int getRightChild(int index) {
		return index*2+1;
	}
	
	//동적으로 자료구조 크기 조절
	private void resize(int newCapacity) {
		//새로 생성할 배열
		Object[] newArray = new Object[newCapacity];
		
		for(int i=1; i<=size; i++) {
			newArray[i] = array[i];
		}
		
		this.array = null; //GC 처리
		this.array = newArray; //새 배열 연결
	}
	
	
	//힙에 데이터 추가
	private void add(E value) {
		//배열이 꽉 찬 경우 크기를 늘려줌
		if(size+1 == array.length)
			resize(array.length*2);
		
		siftUp(size+1, value); //맨 끝에 데이터를 넣어줌
		size++;
	}
	
	//comparator 비교
	private void siftUp(int idx, E target) {
		if(comparator != null) { //comparator 존재
			siftUpComparator(idx, target, comparator);
		}else {
			siftUpComparable(idx, target);
		}
	}
	
	//부모 노드와 비교하면서 위치 정하기(최소 힙, 루트 노드가 최솟값을 가짐)
	private void siftUpComparator(int idx, E target, Comparator<? super E> comp) {
		//root노드보다 클 때까지만 탐색
		while(idx>1) {
			int parent = getParent(idx);
			Object parentVal = array[parent]; //부모 노드의 값
			
			//타겟 값이 부모노드보다 크면 반복문 종료
			if(comp.compare(target, (E)parentVal)>=0) {
				break;
			}
			
			//타겟노드와 부모노드 위치 변경
			array[idx] = parentVal;
			idx = parent;
		}
		//최종적으로 삽입
		array[idx]= target;
	}
	
	//Comparable을 이용한 shift-up
	private void siftUpComparable(int idx, E target) {
		//타겟 노드를 비교할 수 있도록
		Comparable<? super E> comp = (Comparable<? super E>)target;
		
		//root노드보다 클 때까지만 탐색
		while(idx>1) {
			int parent = getParent(idx);
			Object parentVal = array[parent]; //부모 노드의 값
			
			//타겟 값이 부모노드보다 크면 반복문 종료
			if(comp.compareTo((E)parentVal)>=0) {
				break;
			}
			
			//타겟노드와 부모노드 위치 변경
			array[idx] = parentVal;
			idx = parent;
		}
		//최종적으로 삽입
		array[idx]= target;
	}
	
	//최솟값 삭제
	public E remove() {
		if(array[1] == null) { //root 비어있는 경우
			throw new NoSuchElementException();
		}
		
		E result = (E)array[1];	//반환할 루트 노드
		E target = (E)array[size];	//타깃(가장 마지막에 있는 노드를 올림)
		array[size] = null;	//타겟 노드 비우기
		
		siftDown(1, target); //루트 노드 삭제
		return result;
	}
	
	private void siftDown(int idx, E target) {
		if(comparator != null) {
			siftDownComparator(idx, target, comparator);
		}else {
			siftDownComparable(idx, target);
		}
	}
	
	//Comparator을 이용한 sift-down
	private void siftDownComparator(int idx, E target, Comparator<? super E> comp) {
		array[idx] = null;
		size--;
		
		int parent = idx;	//교환을 시작할 부모 노드
		int child;	//교환 될 자식 노드
		
		//자식노드가 없을 때 까지 반복
		while((child = getLeftChild(parent)) <= size) {
			int right = getRightChild(parent);
			Object childVal = array[child];
			
			//오른쪽 자식 노드가 size를 넘지않는지 (값이 있는지) 비교
			//더 작은 자식 노드와 비교해준다
			if(right<=size && comp.compare((E) childVal, (E)array[right])>0) {
				child = right;
				childVal = array[child];
			}
			
			//재배치하는 노드가 자식 노드보다 작은 경우 반복문을 종료한다
			if(comp.compare(target, (E)childVal)<=0)
				break;
			
			//값 변경
			array[parent] = childVal;
			parent = child;

		}
		//최종 위치
		array[parent] = target;
		
		//크기를 1/4로 줄임
		if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}
	}
	
	//Comparable을 이용한 sift-down
	private void siftDownComparable(int idx, E target) {
		
		Comparable<? super E> comp = (Comparable<? super E>)target;
		array[idx] = null;
		size--;
		
		int parent = idx;	//교환을 시작할 부모 노드
		int child;	//교환 될 자식 노드
		
		//자식노드가 없을 때 까지 반복
		while((child = getLeftChild(parent)) <= size) {
			int right = getRightChild(parent);
			Object childVal = array[child];
			
			//오른쪽 자식 노드가 size를 넘지않는지 (값이 있는지) 비교
			//더 작은 자식 노드와 비교해준다
			if(right<=size && ((Comparable<? super E>)childVal).compareTo((E)array[right]) >0 ) {
				child = right;
				childVal = array[child];
			}
			
			//재배치하는 노드가 자식 노드보다 작은 경우 반복문을 종료한다
			if(comp.compareTo((E)childVal)<=0)
				break;
			
			//값 변경
			array[parent] = childVal;
			parent = child;

		}
		//최종 위치
		array[parent] = comp;
		
		//크기를 1/4로 줄임
		if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public E peek() {
		if(array[1]==null)
			throw new NoSuchElementException();
		return (E)array[1];
	}
	
	public Object[] toArray() {
		return Arrays.copyOf(array, size+1);
	}
}
