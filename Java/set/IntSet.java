package set;

public class IntSet {
	private int max;
	private int num;
	private int[] set;
	
	//생성자
	public IntSet(int capacity) {
		num = 0;
		max = capacity;
		try {
			set = new int[max];	//집합 배열 생성			
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	//집합의 최대 개수(max) 반환
	public int capacity() { 
		return max;
	}
	
	//집합의 현재 요소 개수(num) 반환
	public int size() { 
		return num;
	}
	
	//집합에서 n 찾기
	public int indexOf(int n) { 
		for(int i=0; i<num; i++)
			if(set[i]==n)
				return i;	//인덱스 반환
		return -1;	//검색 실패
	}
	
	//집합에 n 있는지 확인
	public boolean contains(int n) {	
		return (indexOf(n) != -1) ? true : false; 
	}
	
	//집합에 n 추가
	public boolean add(int n) {	
		if(num >= max || contains(n) == true) return false;
		else {
			set[num++] = n;
			return true;
		}
	}
	
	//집합에 n 삭제
	public boolean remove(int n) {
		int idx;
		if(num==0 || (idx = indexOf(n)) == -1) return false;
		else {
			set[idx] = set[--num];	//마지막 요소를 삭제한 곳으로 옮김
			return true;
		}
	}
	
	//집합 s에 복사
	public void copyTo(IntSet s) {
		int n = (s.max < num) ? s.max : num;	//복사할 요소 수(복사할 공간보다 n이크면, max까지만 복사)
		for(int i=0; i<n; i++)
			s.set[i] = set[i];
		s.num = n;
	}
	
	//집합 s를 복사
	public void copyFrom(IntSet s) {
		int n = (max < s.num) ? max : s.num;	//복사할 요소 수(복사될 공간보다 복사하는 num이크면, max까지만 복사)
		for(int i=0; i<n; i++)
			set[i] = s.set[i];
		num = n;
	}
	
	//집합 s와 같은지
	public boolean equalTo(IntSet s) {
		if(num != s.num) return false;
		
		for(int i=0; i<num; i++) {
			int j=0;
			for(; j<s.num; j++) { //현재 i요소와 j가 동일할때 값이 같으면 break
				if(set[i] == s.set[j]) break;
			}
			if(j == s.num) return false;	//위 for문에서 break에 들어가지 못하는 경우
		}
		return true;
	}
	
	//집합 s1, s2의 합집합 복사
	public void unionOf(IntSet s1, IntSet s2) {
		copyFrom(s1);	//s1을 현재 집합에 복사
		for(int i=0; i< s2.num; i++)
			add(s2.set[i]);	//s2를 집합 뒤에 복사
	}
	
	//"{ }" 형식으로 출력
	//@override
	public String toString() {
		StringBuffer temp = new StringBuffer("{");
		for(int i=0; i<num; i++)
			temp.append(set[i] + " ");
		temp.append("}");
		return temp.toString();
	}
	
	//공집합 확인
	public boolean isEmpty() {
		return (num == 0) ? true : false;
	}
	
	//집합이 가득 찼는지 확인
	public boolean isFull() {
		return (num == max) ? true : false;
	}
	
	//집합 초기화
	public void clear() {
		num = 0;
	}
}
