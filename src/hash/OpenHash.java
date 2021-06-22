package hash;

import hash.ChainHash.Node;

public class OpenHash<K, V> {
	//버킷 상태
	enum Status {OCCUPIED, EMPTY, DELETED};
	
	//버킷
	static class Bucket<K, V>{
		private K key;			//키 값
		private V data;			//데이터
		private Status stat;	//상태
		
		//생성자
		Bucket(){
			stat = Status.EMPTY;
		}
		
		//모든 필드에 값 설정
		void set(K key, V data, Status stat) {
			this.key = key;
			this.data = data;
			this.stat = stat;
		}
		
		//상태 설정
		void setStat(Status stat) {
			this.stat = stat;
		}
		
		//키&데이터 반환
		K getKey() { return key;	}
		V getValue() { return data;	}
		public int hashCode() { return key.hashCode(); }
		
	}
	
	
	private int size;				//해시 테이블 크기
	private Bucket<K, V>[] table;	//해시 테이블
	
	//생성자
	public OpenHash(int size) {
		try {
			table = new Bucket[size];
			for(int i=0; i<size; i++)
				table[i] = new Bucket<K,V>();
			this.size = size;

		} catch (OutOfMemoryError e) {
			this.size = 0;
		}
	}
	
	//해시 값 구하기
	public int hashValue(Object key) {
		return key.hashCode()%size;
	}
	
	//재해시 값 구하기
	public int rehashValue(int hash) {
		return (hash+1)%size;
	}
	
	
	//key를 가지는 버킷 검색(버킷 반환)
	//선택 버킷 table[hash]부터 시작 ~ rehash하면서 다른 곳에 저장되지 않았는지 확인
	private Bucket<K,V> searchNode(K key){
		int hash = hashValue(key);		//검색할 데이터의 해시 값
		Bucket<K,V> p = table[hash];	//선택 버킷
		
		for(int i=0; p.stat != Status.EMPTY && i<size; i++) {
			//버킷 찾음
			if(p.stat == Status.OCCUPIED && p.getKey().equals(key))	
				return p;
			hash = rehashValue(hash);	//rehash
			p = table[hash];
		}
		return null;
	}
	
	
	//key를 갖는 요소 검색(데이터/인덱스 반환)
	public V search(K key) {
		Bucket<K, V> p = searchNode(key);
		if(p!=null)
			return p.getValue();
		else
			return null;
	}
	
	
	//추가
	public int add(K key, V data) {
		if(search(key) != null) return 1;	//이미 등록된 키
		
		int hash = hashValue(key);	//등록할 데이터 해시 값
		Bucket<K, V> p = table[hash];
		
		for(int i=0; i<size; i++) {
			if(p.stat == Status.EMPTY || p.stat == Status.DELETED) { //삭제 OR 비어있는 경우
				p.set(key, data, Status.OCCUPIED);	//버킷 설정
				return 0;
			}
			hash = rehashValue(hash);	//rehash
			p = table[hash];
		}
		
		return 2;	//해시 가득 참
	}
	
	
	//삭제 -> 한 번 있었던 값이므로 DELETE로 상태 변경
	public int remove(K key) {
		Bucket<K,V> p = searchNode(key);	//버킷 선택
		if(p==null) return 1;				//해당 키 값 없음
		
		p.setStat(Status.DELETED);
		return 0;
	}
	
	
	//출력
	public void dump() {
		for(int i=0; i<size; i++) {
			System.out.printf("%02d ", i);
			
			switch(table[i].stat) {
			case OCCUPIED:
				System.out.printf("%s (%s)\n", table[i].getKey(), table[i].getValue());
				break;
			case EMPTY:
				System.out.println("-- 미등록 --");
				break;
			case DELETED:
				System.out.println("-- 삭제 완료 --");
				break;
			}
			
			System.out.println();
		}
	}
}