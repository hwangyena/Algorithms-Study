package hash;

public class ChainHash<K, V>{
	private int size;	//해시 테이블의 크기
	private Node<K,V>[] table;	//해시 테이블 저장 배열
	
	//해시를 구성하는 노드
	class Node<K, V>{
		private K key;	//key
		private V value;	//value
		private Node<K,V> next;	//node 참조
		
		//생성자
		Node(K key, V value, Node<K,V> next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		K getKey() {
			return key;
		}
		
		V getvalue() {
			return value;
		}
		
		//키의 해시 값 반환
		public int hashCode() {
			return key.hashCode();
		}
	}
	
	//생성자
	public ChainHash(int capacity) {
		try {
			table = new Node[capacity];
			this.size = capacity;
			
		} catch (OutOfMemoryError e) {
			this.size = 0;
		}
	}
	
	//해시값(value) 구하기
	public int hashValue(Object key) {
		return key.hashCode() % size;
	}
	
	//키 값 key를 갖는 요소 검색(데이터 반환)
	public V search(K key) {
		int hash = hashValue(key);	//해시 값 구하기
		Node<K, V> p = table[hash];	//선택한 노드(p)
		
		while(p!=null) {
			if(p.getKey().equals(key))
				return p.getvalue();
			p = p.next;
		}
		return null;	//없는 경우
	}
	
	//node 맨 앞에 삽입, 있는 경우 실패
	public int add(K key, V value) {
		int hash = hashValue(key);
		Node<K, V> p = table[hash];
		
		//이미 등록된 key인지 확인
		while(p!=null) {
			if(p.getKey().equals(key)) return 1;	//이미 등록된 key
			p = p.next;
		}
		Node<K, V> temp = new Node<K,V>(key, value, table[hash]);	//새로운 노드(기존 맨 앞의 node를 참조)
		table[hash] = temp;	//새로운 노드를 맨 앞에 삽입
		return 0;
	}
	
	//key에 해당하는 node 삭제
	public int remove(K key) {
		int hash = hashValue(key);	//삭제할 데이터 해시 값
		Node<K, V> p = table[hash];	//삭제할 노드 담을 곳
		Node<K, V> pp = null;		//삭제할 노드 이전 노드 
		
		while(p!=null) {
			if(p.getKey().equals(key)) {	//삭제할 노드 찾음
				if(pp == null)	//맨 앞 노드 삭제!
					table[hash] = p.next;
				else	//중간 노드 삭제
					pp.next = p.next;
				return 0;
			}
			pp = p;
			p = p.next;
		}
		return 1;
	}
	
	//해시 테이블 덤프(출력)
	public void dump() {
		for(int i=0; i<size; i++) {
			Node<K, V> p =table[i];
			System.out.printf("%02d ", i);
			while(p!=null) {
				System.out.printf("-> %s (%s)  ", p.getKey(), p.getvalue());
				p = p.next;
			}
			System.out.println();
		}
	}
	
	static public void main(String[] args) {
		
	}

}
